package pl.kosowski.intentservice.activities;

import androidx.appcompat.app.AppCompatActivity;
import pl.kosowski.intentservice.R;
import pl.kosowski.intentservice.service.ChuckNorrisIntentService;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickChuckServiceStart(View view){
        Intent intent=new Intent(this,ChuckNorrisIntentService.class);
        startService(intent);
    }

    public void onClickChuckServiceStop(View view){
        Intent intent=new Intent(this,ChuckNorrisIntentService.class);
        stopService(intent);
    }

}
