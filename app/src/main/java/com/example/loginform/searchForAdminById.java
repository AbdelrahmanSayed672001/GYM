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

public class searchForAdminById extends AppCompatActivity {

    private Button searchbtn2;
    private EditText search2;
    private TextView resultId,resultName,resultAge;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_admin_by_id);
        database=new Database(this);

        search2=findViewById(R.id.search2);
        searchbtn2=findViewById(R.id.searchbtn2);
        resultId=findViewById(R.id.resultId);
        resultName=findViewById(R.id.resultName);

        searchbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Search=search2.getText().toString();

                try {

                    try {
                        if (Search.equals("")){
                            Toast.makeText(getApplicationContext(),"Please fill the field",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Cursor cursor=database.searchForAdminById(Search);
                            cursor.moveToFirst();
                            resultId.setText("ID: "+cursor.getString(0));
                            resultName.setText("\nName: "+cursor.getString(1));
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