package com.example.readjson;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.IOException;

public class MediaOnlineSound extends AppCompatActivity {

    Button btPlayMusic;
    ProgressBar pbLoadSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_online_sound);

        btPlayMusic = findViewById(R.id.bt_play_media_online);
        pbLoadSound = findViewById(R.id.pb_load_sound);

        pbLoadSound.setVisibility(View.GONE);
        btPlayMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String url = "http://rejected-box.000webhostapp.com/music/RangKhon-PhiPhuongAnhTheFaceRIN9-7006388%20(1).mp3";
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                    pbLoadSound.setVisibility(View.VISIBLE);
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                            pbLoadSound.setVisibility(View.GONE);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}