package com.example.readjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.readjson.Interface.DataVariable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONObjectData extends AppCompatActivity implements DataVariable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonobject);

        new ReadJsonObj().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json");

    }

    private class ReadJsonObj extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            StringBuilder content = new StringBuilder();

            try {
                URL url = new URL(strings[0]);

//              DATA INPUT
                InputStreamReader inputStreamReader =
                        new InputStreamReader(url.openConnection().getInputStream());

//              READ ALL DATA
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";

//                Read Line paragrap
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }

                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObjectData = new JSONObject(s);
                String subject = jsonObjectData.getString(SUBJECT);
                Toast.makeText(JSONObjectData.this, "" + subject, Toast.LENGTH_SHORT).show();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}