package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.Database;

public class loginForm extends AppCompatActivity {

    private EditText idLogin,passwordLogin;
    private Button login;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        database=new Database(this);

        idLogin=findViewById(R.id.idLogin);
        passwordLogin=findViewById(R.id.passwordLogin);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDLogin=idLogin.getText().toString();
                String PasswordLogin=passwordLogin.getText().toString();

                try {
                    if (IDLogin.equals("") || PasswordLogin.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_LONG).show();
                    }
                    else {
                        boolean result=database.login(IDLogin,PasswordLogin);
                        if (result){
                            Toast.makeText(getApplicationContext(),"Welcome "+IDLogin,Toast.LENGTH_LONG).show();
                            Intent intent =new Intent(loginForm.this, AdminHome.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_LONG).show();
                        }

                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}