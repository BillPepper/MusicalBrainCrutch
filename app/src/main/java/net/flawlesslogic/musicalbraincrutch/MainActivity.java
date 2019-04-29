package net.flawlesslogic.musicalbraincrutch;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MusicEntry> arrSongList = new ArrayList<MusicEntry>();
    MusicEntry s1 = new MusicEntry("Toe to Toes", "Mastodon", 0, "EADGBE");
    MusicEntry s2 = new MusicEntry("Chan chan", "Buena Vista Social Club", 5, "EADGBE");
    MusicEntry s3 = new MusicEntry("Just Jamming", "Gramatik", 2, "EADGBE");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSongList();
    }

    protected void setupSongList(){
        arrSongList.add(s1);
        arrSongList.add(s2);
        arrSongList.add(s3);

        MusicEntryAdapter musicEntryAdapter = new MusicEntryAdapter(this, arrSongList);

        ConstraintLayout uiSongList = findViewById(R.id.loSongList);
        ListView songList = new ListView(this);
        songList.setAdapter(musicEntryAdapter);

        uiSongList.addView(songList);
    }
}
