package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        Button playBtn = (Button) findViewById (R.id.play);
        //final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.song);
        if (playBtn != null) {
            playBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaPlayer.start(); // no need to call prepare(); create() does that for you
                  //  Toast.makeText(MainActivity.this, "play", Toast.LENGTH_SHORT).show();

                }
            });
        }

        Button PauseBtn = (Button) findViewById (R.id.pause);
        if (PauseBtn != null) {
            PauseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   mediaPlayer.pause();

                }
            });
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "I'm done", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
