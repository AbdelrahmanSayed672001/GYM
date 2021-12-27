package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.Database;

public class addAdmin extends AppCompatActivity {

    private EditText idAddAdmin,nameAddAdmin,passwordAddAdmin;
    private Button addAdmin;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin);
        database=new Database(this);

        idAddAdmin=findViewById(R.id.idAddAdmin);
        nameAddAdmin=findViewById(R.id.nameAddAdmin);
        passwordAddAdmin=findViewById(R.id.passwordAddAdmin);
        addAdmin=findViewById(R.id.addAdmin);

        addAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDAddadmin= idAddAdmin.getText().toString();
                String NameAddadmin=nameAddAdmin.getText().toString();
                String PasswordAddadmin=passwordAddAdmin.getText().toString();

                try {

                    if (IDAddadmin.equals("") || NameAddadmin.equals("") || PasswordAddadmin.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_LONG).show();
                    }
                    else {
                        database.adminInsert(IDAddadmin,NameAddadmin,PasswordAddadmin);
                        Toast.makeText(getApplicationContext(),NameAddadmin+" is saved as a admin",Toast.LENGTH_LONG).show();
                    }


                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"A user is not saved",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}