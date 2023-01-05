package com.example.tpdevoirpartie4;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        //mediaPlayer = MediaPlayer.create(this, R.raw.my_music_file);
        Toast.makeText(this, "Service Créé", Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String fileName = intent.getStringExtra("FILE_NAME");
        int resId = getResources().getIdentifier(fileName, "raw", getPackageName());
        mediaPlayer = MediaPlayer.create(this, resId);
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
