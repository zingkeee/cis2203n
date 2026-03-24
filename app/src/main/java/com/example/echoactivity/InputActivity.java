package com.example.echoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    private static final String TAG = "InputActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Log.d(TAG, "InputActivity created");

        EditText editMessage = findViewById(R.id.editMessage);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            String message = editMessage.getText().toString();

            Log.d(TAG, "Button clicked. Sending: " + message);

            Intent intent = new Intent(InputActivity.this, EchoActivity.class);
            intent.putExtra("MSG_KEY", message);
            startActivity(intent);
        });

        Button btnShare = findViewById(R.id.btnShare);

        btnShare.setOnClickListener(v -> {
            String message = editMessage.getText().toString();

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, message);

            Log.d(TAG, "Share button clicked. Triggering Implicit Intent.");

            startActivity(Intent.createChooser(shareIntent, "Share message via:"));
        });
    }
}