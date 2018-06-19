package com.example.subir.servicedemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MusicService musicService;
    MediaPlayer mp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playClicked(View v)
    {
        Intent i = new Intent(MainActivity.this,MusicService.class);
        startService(i);
    }

    public void pauseClicked()
    {
        Intent i = new Intent(MainActivity.this,MusicService.class);
        startService(i);
    }

    public void stopClicked(View v)
    {
        Intent i = new Intent(MainActivity.this,MusicService.class);
        stopService(i);
    }

    public void loopClicked()
    {
        //onLoop();
    }
}
