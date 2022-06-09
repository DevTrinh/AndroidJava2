package com.example.readjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.readjson.Interface.DataVariable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonArray extends AppCompatActivity implements DataVariable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array);

        new ReadJsonArr().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo2.json");
    }

    private class ReadJsonArr extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader =
                        new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";

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

            JSONObject jsonObj = null;
            try {
                jsonObj = new JSONObject(s);
                JSONArray jsonArray = jsonObj.getJSONArray(LIST);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObjecItem = jsonArray.getJSONObject(i);
                    String nameCourse = jsonObjecItem.getString(COURSE);
                    Toast.makeText(JsonArray.this, nameCourse + "", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}