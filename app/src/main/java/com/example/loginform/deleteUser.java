package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.Database;

public class deleteUser extends AppCompatActivity {

    private Button deletebtn;
    private EditText delete;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
        database=new Database(this);

        deletebtn=findViewById(R.id.deletebtn);
        delete=findViewById(R.id.delete);

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Delete=delete.getText().toString();
                try {

                    if (Delete.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill the field,please",Toast.LENGTH_LONG).show();
                    }
                    else {
                        database.deleteUser(Delete);
                        Toast.makeText(getApplicationContext(),Delete+" is deleted successfully",Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}