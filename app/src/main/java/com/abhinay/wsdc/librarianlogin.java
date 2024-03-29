package com.abhinay.wsdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class librarianlogin extends AppCompatActivity {
    private EditText userid,passid;
    private Button login,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarianlogin2);
        userid = findViewById(R.id.usernametxt);
        passid = findViewById(R.id.passcodetxt);
        login  = findViewById(R.id.btnlogin);
        back = findViewById(R.id.btnbackhome);
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String a = userid.getText().toString();
                String b = passid.getText().toString();
                if(a.isEmpty()||b.isEmpty())
                {
                    Toast.makeText(librarianlogin.this, "Please enter all the data", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(a.equals("library")&&b.equals("1729"))
                {
                    userid.setText("");
                    passid.setText("");
                    Intent i = new Intent(librarianlogin.this, librarian.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(librarianlogin.this, "Please enter correct details ", Toast.LENGTH_SHORT).show();
                    return ;
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(librarianlogin.this, start.class);
                startActivity(i);
            }
        });
    }
}