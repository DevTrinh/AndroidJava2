package com.example.readjson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.readjson.Interface.DataVariable;


public class MainActivity extends AppCompatActivity implements DataVariable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mn_navigation, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.it_json_object:
                startActivity(new Intent(this, JSONObjectData.class));
                break;
            case R.id.json_array:
                startActivity(new Intent(this, JsonArray.class));
                break;
            case R.id.it_json_language:
                startActivity(new Intent(this, JsonLanguage.class));
                break;
            case R.id.it_json_array_obj:
                startActivity(new Intent(this, JsonArrayObject.class));
                break;
            case R.id.it_volley_simple_request:
                startActivity(new Intent(this, VolleySimpleRequest.class));
                break;
            case R.id.it_music_demo:
                startActivity(new Intent(this, ListenMusicVideoDemo.class));
                break;
            case R.id.it_music_app:
                startActivity(new Intent(this, AppMusic.class));
                break;
            case R.id.it_media_online_sound:
                startActivity(new Intent(this, MediaOnlineSound.class));
                break;
            case R.id.it_SQLite_to_do_list1:
                startActivity(new Intent(this, SQLiteToDoList.class));
        }
        return super.onOptionsItemSelected(item);
    }
}