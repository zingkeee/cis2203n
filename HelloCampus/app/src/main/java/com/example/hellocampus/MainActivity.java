package com.example.hellocampus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Requirement: Hardcode Student ID into the Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ID: 24105222");
        }

        // Link the UI elements from the XML
        Button myButton = findViewById(R.id.btnChangeName);
        final TextView myText = findViewById(R.id.tvDepartment);

        // Button Click Listener logic
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change this to the actual name of your Department Chairwoman
                myText.setText("Ms. Angie");
            }
        });
    }
}