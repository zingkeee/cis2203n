package com.example.echoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EchoActivity extends AppCompatActivity {
    private static final String TAG = "EchoActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);

        Log.d(TAG, "EchoActivity created");

        TextView txtDisplay = findViewById(R.id.txtDisplay);

        Intent intent = getIntent();
        String receivedMessage = intent.getStringExtra("MSG_KEY");

        if (receivedMessage != null) {
            txtDisplay.setText(receivedMessage);
            Log.d(TAG, "Successfully received: " + receivedMessage);
        }
    }
}