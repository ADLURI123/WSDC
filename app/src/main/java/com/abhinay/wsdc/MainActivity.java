package com.abhinay.wsdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button registerbtn,loggingbtn,gobackhomebtn;
    private EditText idploginidEdt,idppasswordEdt;
    private DBhandler dbhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerbtn = findViewById(R.id.btnregister);
        idploginidEdt = findViewById(R.id.idploginid);
        idppasswordEdt = findViewById(R.id.idppassword);
        loggingbtn = findViewById(R.id.btnlogin);
        gobackhomebtn = findViewById(R.id.btnbackhome);
        loggingbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String a = idploginidEdt.getText().toString();
                String b = idppasswordEdt.getText().toString();
                dbhandler = new DBhandler(MainActivity.this);
                if (a.isEmpty()||b.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(dbhandler.check(a,b))
                {
                    Intent i = new Intent(MainActivity.this, homescreen.class);
                    startActivity(i);
                }
                else if(!dbhandler.check(a,b))
                {
                    Toast.makeText(MainActivity.this, "Please enter correct details ", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        registerbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, signup.class);
                startActivity(i);
            }
        });
        gobackhomebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, start.class);
                startActivity(i);
            }
        });
    }
}