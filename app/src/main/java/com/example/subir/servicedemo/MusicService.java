package com.example.subir.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.media.AudioManager;

public class MusicService extends Service {

    MediaPlayer mp ;
    AudioManager audioManager;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(getApplicationContext(), R.raw.friends_anne_marie_marshmello);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        mp.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mp.isPlaying()){
            mp.stop();
        }
    }

    public void onPause(){
        if (mp.isPlaying()) {
            mp.pause();
        }
    }

    public void onLoop(){
        if(mp.isLooping()){
            mp.setLooping(false);
        }
        else{
            mp.setLooping(true);
        }
    }
}
