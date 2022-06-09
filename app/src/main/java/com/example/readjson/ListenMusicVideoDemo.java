package com.example.readjson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class ListenMusicVideoDemo extends AppCompatActivity {

    Button btMusic;
    Button btVideo;
    VideoView vvVideo;

    static int NUMBER = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_demo);

        mapping();

        MediaPlayer mediaPlayer = MediaPlayer.create(ListenMusicVideoDemo.this, R.raw.phiasaumotcogai);

        btVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vvVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vd_hmm));
                vvVideo.start();

                MediaController mediaController = new MediaController(ListenMusicVideoDemo.this);
            }
        });

        btMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (NUMBER == 3) {
                    NUMBER = 2;
                    mediaPlayer.start();
                } else {
                    NUMBER = 3;
                    mediaPlayer.pause();
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
        if (item.getItemId() == R.id.it_home) {
            startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void mapping() {
        btVideo = findViewById(R.id.bt_play_video);
        btMusic = findViewById(R.id.bt_play_music);
        vvVideo = findViewById(R.id.vv_video);
    }
}