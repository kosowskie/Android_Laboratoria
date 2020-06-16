package pl.kosowski.intentservice.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.VolleyError;

import pl.kosowski.intentservice.R;
import pl.kosowski.intentservice.activities.MainActivity;


public class ChuckNorrisIntentService extends IntentService {

    private static final String TAG="pl.kosowski.intentservice.service";
    public static final int NOTIFICATION_ID=5453;

    public ChuckNorrisIntentService() {
        super("ChuckNorrisIntentService");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this){
            try {
                wait(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        loadChuckNorrisFact();
    }

    private void loadChuckNorrisFact() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.chucknorris.io/jokes/random";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String chuckFact = response.getString("value");
                            Log.i(TAG,chuckFact);
                            showNotification(chuckFact);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });queue.add(request);
    }

    public void showNotification(String chuckFact){
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this,"my_channel_01")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentText(chuckFact)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
