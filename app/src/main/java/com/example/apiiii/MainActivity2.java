package com.example.apiiii;

import androidx.appcompat.app.AppCompatActivity;

import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);    
        Button save = findViewById(R.id.buttom6);
        EditText name=findViewById(R.id.editTextTextPersonName) , phone=findViewById(R.id.editTextPhone);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new onlineSave().execute();

            }
        });
    }
    class onlineSave extends AsyncTask<String,Void ,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String Link = "http://www.json-generator.com/api/json/get/bVNWRDDBhK";
            URL myUrl= null;
            HttpURLConnection con = null;
            try {

                myUrl = new URL(Link);
                con = (HttpURLConnection)myUrl.openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);
                con.setDoOutput(true);
                BufferedReader x = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String y=x.readLine();
                return y;
            } catch (ProtocolException e) {
                return e.toString();
            }
            catch (IOException e) {
                return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            s = s.replace("\"" ,"");
            s = s.replace(":" ,"");
            s = s.replace("[{" ,"");
            s = s.replace("}]" ,"");
            s = s.replace("{" ,"");
            s = s.replace("}" ,"");
            s = s.replace("index" ,"");
            s = s.replace("phone" ,"");
            s = s.replace("_id" ,"");
            s = s.replace("," ,"\n");
            String[] x = {s};
            EditText txt = findViewById(R.id.txt);
            adapter b = new adapter(x,getApplicationContext());
            ListView y = findViewById(R.id.lv);
            y.setAdapter(b);
            txt.setText(s);
            super.onPostExecute(s);
        }
    }
}