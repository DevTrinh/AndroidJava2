package com.example.readjson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.readjson.Interface.DataVariable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonLanguage extends AppCompatActivity implements DataVariable {

    CheckBox cbLanguage;
    TextView tvInfo;

    static String languageVN1;
    static String languageEN1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_language);

        mapping();

        new ReadJsonLanguage().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");

        cbLanguage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbLanguage.isChecked()){
                    tvInfo.setText(languageEN1);
                }
                else{
                    tvInfo.setText(languageVN1);
                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mn_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.it_home){
            startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void mapping() {
        cbLanguage = findViewById(R.id.cb_language);
        tvInfo = findViewById(R.id.tv_info);
    }

    public class LanguageObject {
        private String name;
        private String address;
        private String course1;
        private String course2;
        private String course3;

        public LanguageObject(String string, String objectVNString, String vnString, String s) {

        }

        public LanguageObject(String name, String address, String course1, String course2, String course3) {
            this.name = name;
            this.address = address;
            this.course1 = course1;
            this.course2 = course2;
            this.course3 = course3;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCourse1() {
            return course1;
        }

        public void setCourse1(String course1) {
            this.course1 = course1;
        }

        public String getCourse2() {
            return course2;
        }

        public void setCourse2(String course2) {
            this.course2 = course2;
        }

        public String getCourse3() {
            return course3;
        }

        public void setCourse3(String course3) {
            this.course3 = course3;
        }

        public String getInfo(){
            String information;
            information =
                    String.format("Name: %s\nAddress: %s\nCourse1: %s\nCourse2: %s\nCourse3: %s",
                            getName(), getAddress(), getCourse1(),getCourse2(),getCourse3());
            return  information;
        }
    }

    private class ReadJsonLanguage extends AsyncTask<String, Void, String> {

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
                JSONObject jsonObject = new JSONObject(s);
                JSONObject objectLanguage = jsonObject.getJSONObject(LANGUAGE);
                JSONObject objectVN = objectLanguage.getJSONObject(VN);
                JSONObject objectEN = objectLanguage.getJSONObject(EN);

                LanguageObject languageVN =
                        new LanguageObject(objectVN.getString(NAME),
                                objectVN.getString(ADDRESS_LANGUAGE),
                                objectVN.getString(COURSE1),
                                objectVN.getString(COURSE2),
                                objectVN.getString(COURSE3));

                LanguageObject languageEN =
                        new LanguageObject(objectVN.getString(NAME),
                                objectEN.getString(ADDRESS_LANGUAGE),
                                objectEN.getString(COURSE1),
                                objectEN.getString(COURSE2),
                                objectEN.getString(COURSE3));

                tvInfo.setText(languageVN.getInfo());

                languageEN1 = languageEN.getInfo();
                languageVN1 = languageVN.getInfo();

                Toast.makeText(JsonLanguage.this, languageEN.getInfo()+"", Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


}