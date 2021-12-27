package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Database.Database;

public class searchForUserById extends AppCompatActivity {

    private Button searchbtn;
    private EditText search;
    private TextView resultId,resultName,resultAge;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_user_by_id);
        database=new Database(this);

        search=findViewById(R.id.search);
        searchbtn=findViewById(R.id.searchbtn);
        resultId=findViewById(R.id.resultId);
        resultName=findViewById(R.id.resultName);
        resultAge=findViewById(R.id.resultAge);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Search=search.getText().toString();

                try {

                    try {
                        if (Search.equals("")){
                            Toast.makeText(getApplicationContext(),"Please fill the field",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Cursor cursor=database.searchForUserById(Search);
                            cursor.moveToFirst();
                            resultId.setText("ID: "+cursor.getString(0));
                            resultName.setText("\nName: "+cursor.getString(1));
                            resultAge.setText("Age: "+cursor.getString(2));
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