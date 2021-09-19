package com.abhinay.wsdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class homescreen extends AppCompatActivity {
    private TextView userid,name,roll,branch,mobile,email,hostel,library;
    private DBhandler dbhandler;
    private Button addpayement,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        dbhandler = new DBhandler(homescreen.this);
        userid = findViewById(R.id.sid);
        name = findViewById(R.id.p);
        roll = findViewById(R.id.roll);
        branch = findViewById(R.id.branch);
        mobile = findViewById(R.id.mobile);
        email = findViewById(R.id.email);
        addpayement = findViewById(R.id.payupload);
        hostel = findViewById(R.id.hosdue);
        library = findViewById(R.id.libdue);
        logout = findViewById(R.id.stdlogout);
        Intent intent = getIntent();
        String a = intent.getStringExtra("loginid");
        Student student = dbhandler.getdetails(a);
        userid.setText(a);
        name.setText(student.getname());
        roll.setText(student.getroll());
        branch.setText(student.getBranch());
        mobile.setText(student.getMobile());
        email.setText(student.getEmail());
        hostel.setText(Integer.toString(student.gethosteldue()));
        library.setText(Integer.toString(student.getlibrarydue()));
        addpayement.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(homescreen.this, upload.class);
                i.putExtra("roll",student.getroll());
                startActivity(i);
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