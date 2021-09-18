package com.abhinay.wsdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class wardenlogin extends AppCompatActivity {
    private EditText userid,passid;
    private Button login,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardenlogin);
        userid = findViewById(R.id.f);
        passid = findViewById(R.id.g);
        login  = findViewById(R.id.h);
        back = findViewById(R.id.i);
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String a = userid.getText().toString();
                String b = passid.getText().toString();
                if(a.isEmpty()||b.isEmpty())
                {
                    Toast.makeText(wardenlogin.this, "Please enter all the data", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(a.equals("warden")&&b.equals("1234"))
                {
                    userid.setText("");
                    passid.setText("");
                    Intent i = new Intent(wardenlogin.this, warden.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(wardenlogin.this, "Please enter correct details ", Toast.LENGTH_SHORT).show();
                    return ;
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(wardenlogin.this, start.class);
                startActivity(i);
            }
        });
    }
}