package com.example.apiiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addNew = findViewById(R.id.addnew);
        Button veiwAll=findViewById(R.id.viewall);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x =  new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(x);
            }
        });
    }


}