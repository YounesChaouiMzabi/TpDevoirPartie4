package com.example.tpdevoirpartie4;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class MyPlayList extends AppCompatActivity {

    private ListView listView;
    private Button buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_playlist);

        // Récupérez les vues de l'interface utilisateur
        listView = (ListView) findViewById(R.id.list_view);
        buttonStop = (Button) findViewById(R.id.button_stop);

        // Créez un tableau de titres de chansons
        String[] songs = {"Song 1", "Song 2", "Song 3", "Song 4", "Song 5"};

        // Créez un adapteur pour lier les titres de chansons à la ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songs);
        listView.setAdapter(adapter);
        // Dans la méthode onCreate de MyPlayList

// Récupérez la vue de la ListView
        ListView listView = findViewById(R.id.list_view);

// Définissez un listener pour la ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Récupérez le titre de la chanson sélectionnée
                String selectedSong = (String) parent.getItemAtPosition(position);

                // Envoyez un Intent au service pour jouer la chanson sélectionnée
                Intent startIntent = new Intent(MyPlayList.this, MyService.class);
                startIntent.putExtra("FILE_NAME", selectedSong);
                startService(startIntent);
            }
        });




                // Définissez un listener pour le bouton Stop
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arrêtez la musique en envoyant un Intent au service
                Intent stopIntent = new Intent(MyPlayList.this, MyService.class);
                stopService(stopIntent);
            }
        });
    }
}
