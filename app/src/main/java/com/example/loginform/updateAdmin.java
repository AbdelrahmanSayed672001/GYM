package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.Database;

public class updateAdmin extends AppCompatActivity {

    private EditText idUpdateAdmin,nameUpdateAdmin,passwordUpdateAdmin;
    private Button updateAdmin;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_admin);
        database=new Database(this);

        idUpdateAdmin=findViewById(R.id.idUpdateAdmin);
        nameUpdateAdmin=findViewById(R.id.nameUpdateAdmin);
        passwordUpdateAdmin=findViewById(R.id.passwordUpdateAdmin);
        updateAdmin=findViewById(R.id.updateAdmin);

        updateAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDUpdateAdmin=idUpdateAdmin.getText().toString();
                String NameUpdateAdmin=nameUpdateAdmin.getText().toString();
                String PasswordUpdateAdmin=passwordUpdateAdmin.getText().toString();

                try {

                    if (IDUpdateAdmin.equals("") || NameUpdateAdmin.equals("")
                            ||PasswordUpdateAdmin.equals("") ){
                        Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_LONG).show();
                    }
                    else {
                        database.updateAdmin(IDUpdateAdmin,NameUpdateAdmin,PasswordUpdateAdmin);
                        Toast.makeText(getApplicationContext(),NameUpdateAdmin+" is updated successfully ",Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"data is not updated",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}