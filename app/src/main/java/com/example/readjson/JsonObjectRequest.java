package com.example.readjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class JsonObjectRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_object_request);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json";
        JsonArrayObject jsonObjectRequest = new JsonArrayObject();

    }
}