package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMenu extends AppCompatActivity {

    private Button addAdmin,deleteAdmin,updateAdmin,searchForAdminById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        addAdmin=findViewById(R.id.addAdmin);
        deleteAdmin=findViewById(R.id.deleteAdmin);
        updateAdmin=findViewById(R.id.updateAdmin);
        searchForAdminById=findViewById(R.id.searchForAdminById);

        addAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminMenu.this,addAdmin.class);
                startActivity(intent);
            }
        });

        deleteAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminMenu.this,deleteAdmin.class);
                startActivity(intent);
            }
        });

        updateAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminMenu.this,updateAdmin.class);
                startActivity(intent);
            }
        });

        searchForAdminById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminMenu.this,searchForAdminById.class);
                startActivity(intent);
            }
        });


    }
}