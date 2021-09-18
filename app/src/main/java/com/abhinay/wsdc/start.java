package com.abhinay.wsdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start extends AppCompatActivity {
    private Button startlogin,startregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startlogin = findViewById(R.id.startlogin);
        startregister = findViewById(R.id.startregister);
        startlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(start.this, intermediate.class);
                startActivity(i);
            }
        });
        startregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(start.this, signup.class);
                startActivity(i);
            }
        });
    }
}