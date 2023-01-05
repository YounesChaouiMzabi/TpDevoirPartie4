package com.example.tpdevoirpartie4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonQuit;
    Button buttonPlay;
    Button buttonStop;
    Button buttonList;
    String fileName = "my_music_file.mp3";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonQuit = findViewById(R.id.button_quit);
        buttonPlay = findViewById(R.id.button_play);
        buttonStop = findViewById(R.id.button_stop);
        buttonList = findViewById(R.id.button_list);

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MyPlayList.class);
                startActivity(intent);
            }
        });


        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Terminer l'application
            }
        });
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(MainActivity.this, MyService.class);
                startIntent.putExtra("FILE_NAME", fileName);
                startService(startIntent);
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopIntent = new Intent(MainActivity.this, MyService.class);
                stopService(stopIntent);
            }
        });





    }





}