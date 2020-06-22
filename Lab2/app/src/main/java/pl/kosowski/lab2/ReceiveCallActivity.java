package pl.kosowski.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveCallActivity extends AppCompatActivity {
    public static final String EXTRA_PHONE_HUMBER = "number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_call);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        TextView textView = findViewById(R.id.number);
        textView.setText(messageText);
    }
}