package com.abhinay.wsdc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class librarian extends AppCompatActivity {
    private Button edit,logout;
    private EditText roll,due;
    private DBhandler dBhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarian);
        roll = findViewById(R.id.libroll);
        due = findViewById(R.id.libfee);
        edit = findViewById(R.id.btnlibdue);
        logout = findViewById(R.id.liblogout);
        dBhandler = new DBhandler(librarian.this);
        edit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String a = roll.getText().toString();
                String b = due.getText().toString();
                if(a.isEmpty()||b.isEmpty())
                {
                    Toast.makeText(librarian.this, "Please enter all the data", Toast.LENGTH_SHORT).show();
                    return ;
                }
                int c = Integer.parseInt(b);
                dBhandler.addlibdue(a,c);
                roll.setText("");
                due.setText("");
                Toast.makeText(librarian.this, "Due is edited", Toast.LENGTH_SHORT).show();
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