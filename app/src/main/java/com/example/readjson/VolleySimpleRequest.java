package com.example.readjson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleySimpleRequest extends AppCompatActivity {

    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_simple_request);

        mapping();
//      instance
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.google.com/";

//      Request a string  response from the provided URL
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                return data if url true
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tvContent.setText(response);
                    }
                },
//                return data if false
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(VolleySimpleRequest.this, error + "", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mn_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.it_home) {
            startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void mapping() {
        tvContent = findViewById(R.id.tv_volley_content);
    }
}