package com.abhinay.wsdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class warden extends AppCompatActivity {
    private Button edit,logout;
    private EditText roll,due;
    private DBhandler dBhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden);
        roll = findViewById(R.id.editTextTextPersonName);
        due = findViewById(R.id.editTextTextPersonName2);
        edit = findViewById(R.id.button3);
        logout = findViewById(R.id.wardlogout);
        dBhandler = new DBhandler(warden.this);
        edit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String a = roll.getText().toString();
                String b = due.getText().toString();
                if(a.isEmpty()||b.isEmpty())
                {
                    Toast.makeText(warden.this, "Please enter all the data", Toast.LENGTH_SHORT).show();
                    return ;
                }
                int c = Integer.parseInt(b);
                dBhandler.addhosteldue(a,c);
                roll.setText("");
                due.setText("");
                Toast.makeText(warden.this, "Due is edited", Toast.LENGTH_SHORT).show();
            }
        });
        logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
                System.exit(0);
            }
        });
    }
}