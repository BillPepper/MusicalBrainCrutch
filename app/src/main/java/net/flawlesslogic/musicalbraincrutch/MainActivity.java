package net.flawlesslogic.musicalbraincrutch;

import android.content.Intent;
import android.database.Cursor;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MusicEntry> arrSongList = new ArrayList<>();
    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSongList();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.setupSongList();
    }

    protected void setupSongList(){
        Cursor c = databaseHelper.getAllEntries();
        try {
        if (c != null){
            c.moveToFirst();
        } do  {
            MusicEntryFactory mf = new MusicEntryFactory();
            arrSongList.add(mf.getMusicEntry(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getInt(3),
                    c.getString(4)
            ));
        } while (c.moveToNext());

        c.close();} catch (Exception e) {
            Log.e("songlist", "setupSongList: can't load data", e);
        }


        MusicEntryAdapter musicEntryAdapter = new MusicEntryAdapter(this, arrSongList);

        ConstraintLayout uiSongList = findViewById(R.id.loSongList);
        ListView songList = new ListView(this);
        songList.setAdapter(musicEntryAdapter);

        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                handleItemClick(position);
            }
        });

        uiSongList.addView(songList);

        FloatingActionButton addButton = findViewById(R.id.btnAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAddClick();
            }
        });
    }

    protected void handleItemClick(int pos){
        CharSequence text = "You clicked " + arrSongList.get(pos).songName;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getBaseContext(), text, duration);
        toast.show();
        Intent intent = new Intent(this, DebugActivity.class)
                .putExtra("songName", arrSongList.get(pos).songName)
                .putExtra("songArtist", arrSongList.get(pos).songArtist);
        
        startActivity(intent);
    }

    protected void handleAddClick(){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);

//        CharSequence toastText = "Something went wrong";
//
//        if (databaseHelper.addEntry("Curl of the Burl", "Mastodon", 0, "CFBEGC")){
//          toastText = "Added entry";
//        }
//        Toast t = new Toast(this);
//        t.makeText(this, toastText, Toast.LENGTH_SHORT );
//        t.show();
    }
}
