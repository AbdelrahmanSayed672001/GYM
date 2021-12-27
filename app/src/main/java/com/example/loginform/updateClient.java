package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.*;

public class updateClient extends AppCompatActivity {

    private EditText idUpdateClient,nameUpdateClient,ageUpdateClient;
    private Button updateClient;
    private ClientDatabase clientDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_client);
        clientDatabase=new ClientDatabase(this);

        idUpdateClient=findViewById(R.id.idUpdateClient);
        nameUpdateClient=findViewById(R.id.nameUpdateClient);
        ageUpdateClient=findViewById(R.id.ageUpdateClient);
        updateClient=findViewById(R.id.updateClient);

        updateClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDUpdateClient=idUpdateClient.getText().toString();
                String NameUpdateClient=nameUpdateClient.getText().toString();
                String AgeUpdateClient=ageUpdateClient.getText().toString();

                try {

                    if (IDUpdateClient.equals("") || NameUpdateClient.equals("")
                            || AgeUpdateClient.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_LONG).show();
                    }
                    else {
                        clientDatabase.updateClient(IDUpdateClient,NameUpdateClient,AgeUpdateClient);
                        Toast.makeText(getApplicationContext(),NameUpdateClient+" is updated successfully ",Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"data is not updated",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}