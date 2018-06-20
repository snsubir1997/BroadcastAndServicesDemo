package com.example.subir.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.SeekBar;
import android.widget.Toast;

public class MusicService extends Service {

    MediaPlayer mp ;
    static int pos;


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
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getStringExtra("serviceTag").equals("onPlay")) {
            mp.seekTo(pos);
            mp.start();
        }
        else if(intent.getStringExtra("serviceTag").equals("onPause")){
            mp.pause();
            pos = mp.getCurrentPosition();
        }
        else if(intent.getStringExtra("serviceTag").equals("onLoop")){
            if(mp.isLooping()){
                mp.setLooping(false);
                Toast.makeText(getApplicationContext(),"NOT LOOPING", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"LOOPING", Toast.LENGTH_SHORT).show();
                mp.setLooping(true);
            }
        }
        else{

        }

            return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mp.isPlaying()){
            mp.stop();
            pos = 0;
        }
    }
}
