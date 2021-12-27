package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.*;

public class addClient extends AppCompatActivity {

    private EditText idAddClient,nameAddClient,ageAddClient;
    private Button addClient;
    private ClientDatabase clientDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        clientDatabase=new ClientDatabase(this);

        idAddClient=findViewById(R.id.idAddClient);
        nameAddClient=findViewById(R.id.nameAddClient);
        ageAddClient=findViewById(R.id.ageAddClient);
        addClient=findViewById(R.id.addClient);

        addClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDAddclient= idAddClient.getText().toString();
                String NameAddclient=nameAddClient.getText().toString();
                String AgeAddclient=ageAddClient.getText().toString();

                try {

                    if (IDAddclient.equals("") || NameAddclient.equals("") || AgeAddclient.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_LONG).show();
                    }
                    else {
                        clientDatabase.addClient(IDAddclient,NameAddclient,AgeAddclient);
                        Toast.makeText(getApplicationContext(),NameAddclient+" is saved as a client",Toast.LENGTH_LONG).show();
                    }


                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"A user is not saved",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}