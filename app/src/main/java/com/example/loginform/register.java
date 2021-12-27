package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.Database;

public class register extends AppCompatActivity {

    private EditText id,name,password;
    private Button adminRegisteration;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        database=new Database(this);

        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        adminRegisteration=findViewById(R.id.registeration);

        adminRegisteration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID=id.getText().toString();
                String Name=name.getText().toString();
                String Password=password.getText().toString();

                try {
                    if (ID.equals("") || Name.equals("") || Password.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_LONG).show();
                    }
                    else {

                        database.adminInsert(ID,Name,Password);
                        Toast.makeText(getApplicationContext(),Name+" is saved as an admin",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(register.this, loginForm.class);
                        startActivity(intent);
                    }
                }catch (Exception exception){
                    Toast.makeText(getApplicationContext(),"Not saved",Toast.LENGTH_LONG).show();
                }

            }
        });
    }


}