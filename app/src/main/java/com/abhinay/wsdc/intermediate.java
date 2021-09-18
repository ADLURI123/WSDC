package com.abhinay.wsdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class intermediate extends AppCompatActivity {
    private Button studentbtn,librarianbtn,chiefwardenbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);
        studentbtn = findViewById(R.id.studentportal);
        librarianbtn = findViewById(R.id.librarianportal);
        chiefwardenbtn = findViewById(R.id.chiefwardenportal);
        studentbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(intermediate.this, MainActivity.class);
                startActivity(i);
            }
        });
        librarianbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(intermediate.this, librarianlogin.class);
                startActivity(i);
            }
        });
        chiefwardenbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(intermediate.this, wardenlogin.class);
                startActivity(i);
            }
        });
    }
}