package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.*;

public class deleteClient extends AppCompatActivity {

    private Button deletebtn3;
    private EditText delete3;
    private ClientDatabase clientDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_client);
        clientDatabase=new ClientDatabase(this);

        deletebtn3=findViewById(R.id.deletebtn3);
        delete3=findViewById(R.id.delete3);

        deletebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Delete=delete3.getText().toString();
                try {

                    if (Delete.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill the field,please",Toast.LENGTH_LONG).show();
                    }
                    else {
                        clientDatabase.deleteClient(Delete);
                        Toast.makeText(getApplicationContext(),Delete+" is deleted successfully",Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}