package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.Database;

public class addUser extends AppCompatActivity {

    private EditText idAddUser,nameAddUser,passwordAddUser,ageAddUser;
    private Button addUser;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        database=new Database(this);

        idAddUser=findViewById(R.id.idAddUser);
        nameAddUser=findViewById(R.id.nameAddUser);
        passwordAddUser=findViewById(R.id.passwordAddUser);
        ageAddUser=findViewById(R.id.ageAddUser);
        addUser=findViewById(R.id.addUser);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDAddUser= idAddUser.getText().toString();
                String NameAdduser=nameAddUser.getText().toString();
                String PasswordAdduser=passwordAddUser.getText().toString();
                String AgeAddUser=ageAddUser.getText().toString();

                try {

                    if (IDAddUser.equals("") || NameAdduser.equals("") || PasswordAdduser.equals("") || AgeAddUser.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_LONG).show();
                    }
                    else {
                        database.addUser(IDAddUser,NameAdduser,PasswordAdduser,AgeAddUser);
                        Toast.makeText(getApplicationContext(),NameAdduser+" is saved as a user",Toast.LENGTH_LONG).show();
                    }


                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"A user is not saved",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}