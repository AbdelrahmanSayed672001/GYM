package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHomeUser extends AppCompatActivity {

    private Button addUser,deleteUser,updateUser,searchForUserById,myInfo,client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_user);

        addUser=findViewById(R.id.addUser);
        deleteUser=findViewById(R.id.deleteUser);
        updateUser=findViewById(R.id.updateUser);
        searchForUserById=findViewById(R.id.searchForUserById);
        client=findViewById(R.id.client);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminHomeUser.this,addUser.class);
                startActivity(intent);
            }
        });

        searchForUserById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminHomeUser.this,searchForUserById.class);
                startActivity(intent);
            }
        });

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminHomeUser.this,deleteUser.class);
                startActivity(intent);
            }
        });

        updateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminHomeUser.this,updateUser.class);
                startActivity(intent);
            }
        });







    }
}