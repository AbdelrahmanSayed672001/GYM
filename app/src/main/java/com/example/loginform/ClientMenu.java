package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClientMenu extends AppCompatActivity {

    private Button addClient,deleteClient,updateClient,searchForClientById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_menu);

        addClient=findViewById(R.id.addClient);
        deleteClient=findViewById(R.id.deleteClient);
        updateClient=findViewById(R.id.updateClient);
        searchForClientById=findViewById(R.id.searchForClientById);

        addClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ClientMenu.this,addClient.class);
                startActivity(intent);
            }
        });

        deleteClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ClientMenu.this,deleteClient.class);
                startActivity(intent);
            }
        });

        updateClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ClientMenu.this,updateClient.class);
                startActivity(intent);
            }
        });

        searchForClientById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ClientMenu.this,searchForClientById.class);
                startActivity(intent);
            }
        });
    }
}