package com.abhinay.wsdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private EditText nameEdt,rollEdt,branchEdt,mobileEdt,emailEdt,loginidEdt,passwordEdt;
    private Button registerBtn,backBtn;
    private DBhandler DBhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nameEdt = findViewById(R.id.idname);
        rollEdt = findViewById(R.id.idroll);
        branchEdt = findViewById(R.id.idbranch);
        mobileEdt = findViewById(R.id.idmobile);
        emailEdt = findViewById(R.id.idemail);
        loginidEdt = findViewById(R.id.idloginid);
        passwordEdt = findViewById(R.id.idpassword);
        registerBtn = findViewById(R.id.Btnsignup);
        backBtn = findViewById(R.id.back);

        DBhandler = new DBhandler(signup.this);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEdt.getText().toString();
                String roll = rollEdt.getText().toString();
                String branch = branchEdt.getText().toString();
                String mobile= mobileEdt.getText().toString();
                String email= emailEdt.getText().toString();
                String loginid = loginidEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                if (name.isEmpty()||roll.isEmpty()||branch.isEmpty()||mobile.isEmpty()||email.isEmpty()||loginid.isEmpty()||password.isEmpty())
                {
                    Toast.makeText(signup.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                DBhandler.addStudent(name,roll,branch,mobile,email,loginid,password);
                Toast.makeText(signup.this, "Your details have been sucessfully saved ", Toast.LENGTH_SHORT).show();
                nameEdt.setText("");
                rollEdt.setText("");
                branchEdt.setText("");
                mobileEdt.setText("");
                emailEdt.setText("");
                loginidEdt.setText("");
                passwordEdt.setText("");
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(signup.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}