package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.Database;

public class deleteAdmin extends AppCompatActivity {

    private Button deletebtn2;
    private EditText delete2;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_admin);
        database=new Database(this);

        deletebtn2=findViewById(R.id.deletebtn2);
        delete2=findViewById(R.id.delete2);

        deletebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Delete=delete2.getText().toString();
                try {

                    if (Delete.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill the field,please",Toast.LENGTH_LONG).show();
                    }
                    else {
                        database.deleteAdmin(Delete);
                        Toast.makeText(getApplicationContext(),Delete+" is deleted successfully",Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}