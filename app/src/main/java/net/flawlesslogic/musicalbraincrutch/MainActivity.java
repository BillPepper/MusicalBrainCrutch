package net.flawlesslogic.musicalbraincrutch;

import android.support.constraint.ConstraintLayout;
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
    MusicEntry s1 = new MusicEntry(1, "Toe to Toes", "Mastodon", 0, "EADGBE");
    MusicEntry s2 = new MusicEntry(2, "Chan chan", "Buena Vista Social Club", 5, "EADGBE");
    MusicEntry s3 = new MusicEntry(3, "Just Jamming", "Gramatik", 2, "EADGBE");
    MusicEntry s4 = new MusicEntry(3, "Nothing Else Matters", "Metallica", 2, "EADGBE");
    MusicEntry s5 = new MusicEntry(3, "Celito Lindo", "Unknown", 2, "EADGBE");


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
        arrSongList.add(s4);
        arrSongList.add(s5);
        arrSongList.add(s1);
        arrSongList.add(s2);
        arrSongList.add(s3);
        arrSongList.add(s4);
        arrSongList.add(s5);
        arrSongList.add(s1);
        arrSongList.add(s2);
        arrSongList.add(s3);
        arrSongList.add(s4);
        arrSongList.add(s5);

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
    }

    protected void handleItemClick(int pos){
        CharSequence text = "You clicked " + arrSongList.get(pos).songName;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getBaseContext(), text, duration);
        toast.show();
    }
}
