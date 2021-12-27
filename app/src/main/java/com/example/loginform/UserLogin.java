package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.Database;

public class UserLogin extends AppCompatActivity {

    private EditText idUserLogin,passwordUserLogin;
    private Button userLogin;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        database=new Database(this);

        idUserLogin=findViewById(R.id.idUserLogin);
        passwordUserLogin=findViewById(R.id.passwordUserLogin);
        userLogin=findViewById(R.id.userLogin);

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDLogin=idUserLogin.getText().toString();
                String PasswordLogin=passwordUserLogin.getText().toString();

                try {
                    if (IDLogin.equals("") || PasswordLogin.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_LONG).show();
                    }
                    else {
                        boolean result=database.userLogin(IDLogin,PasswordLogin);
                        if (result){
                            Toast.makeText(getApplicationContext(),"Welcome "+IDLogin,Toast.LENGTH_LONG).show();
                            Intent intent =new Intent(UserLogin.this, UserHome.class);
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