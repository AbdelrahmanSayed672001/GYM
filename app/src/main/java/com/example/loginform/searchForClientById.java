package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Database.*;

public class searchForClientById extends AppCompatActivity {

    private Button searchbtn3;
    private EditText search3;
    private TextView resultId3,resultName3,resultAge3;
    private ClientDatabase clientDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_client_by_id);
        clientDatabase=new ClientDatabase(this);

        search3=findViewById(R.id.search3);
        searchbtn3=findViewById(R.id.searchbtn3);
        resultId3=findViewById(R.id.resultId3);
        resultName3=findViewById(R.id.resultName3);
        resultAge3=findViewById(R.id.resultAge3);

        searchbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Search=search3.getText().toString();

                try {

                    try {
                        if (Search.equals("")){
                            Toast.makeText(getApplicationContext(),"Please fill the field",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Cursor cursor=clientDatabase.searchForClientById(Search);
                            cursor.moveToFirst();
                            resultId3.setText("ID: "+cursor.getString(0));
                            resultName3.setText("\nName: "+cursor.getString(1));
                            resultAge3.setText("Age: "+cursor.getString(2));
                        }
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),Search+" is not found",Toast.LENGTH_LONG).show();
                    }



                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}