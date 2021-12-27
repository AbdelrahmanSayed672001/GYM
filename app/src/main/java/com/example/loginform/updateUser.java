package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.Database;

public class updateUser extends AppCompatActivity {

    private EditText idUpdateUser,nameUpdateUser,passwordUpdateUser,ageUpdateUser;
    private Button updateUser;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        database=new Database(this);

        idUpdateUser=findViewById(R.id.idUpdateUser);
        nameUpdateUser=findViewById(R.id.nameUpdateUser);
        passwordUpdateUser=findViewById(R.id.passwordUpdateUser);
        ageUpdateUser=findViewById(R.id.ageUpdateUser);
        updateUser=findViewById(R.id.updateUser);

        updateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDUpdateUser=idUpdateUser.getText().toString();
                String NameUpdateUser=nameUpdateUser.getText().toString();
                String PasswordUpdateUser=passwordUpdateUser.getText().toString();
                String AgeUpdateUser=ageUpdateUser.getText().toString();

                try {

                    if (IDUpdateUser.equals("") || NameUpdateUser.equals("")
                            ||PasswordUpdateUser.equals("") || AgeUpdateUser.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_LONG).show();
                    }
                    else {
                        database.updateUser(IDUpdateUser,NameUpdateUser,PasswordUpdateUser,AgeUpdateUser);
                        Toast.makeText(getApplicationContext(),NameUpdateUser+" is updated successfully ",Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"data is not updated",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}