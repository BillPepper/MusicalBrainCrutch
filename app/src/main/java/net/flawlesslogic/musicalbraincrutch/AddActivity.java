package net.flawlesslogic.musicalbraincrutch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_music_entry);

        final EditText songName = findViewById(R.id.etSongName);
        final EditText songArtist = findViewById(R.id.etArtistName);
        final EditText capoPos = findViewById(R.id.etCapoPos);
        final EditText tuning = findViewById(R.id.etTuning);
        final Button addSong = findViewById(R.id.btnAddAccept);
        final DatabaseHelper databaseHelper = new DatabaseHelper(this);

        addSong.setOnClickListener(new View.OnClickListener() {
            CharSequence toastText = "Something went wrong";
            @Override
            public void onClick(View v) {
                if(databaseHelper.addEntry(
                        songName.getText().toString(),
                        songArtist.getText().toString(),
//                        Integer.valueOf(capoPos.getText().toString()),
                        0,
                        tuning.getText().toString())){
                    toastText = "Added " + songName.getText().toString() + "to the list.";
                }
                Toast t = new Toast(getBaseContext());
                t.makeText(getBaseContext(), toastText, Toast.LENGTH_SHORT);
            }
        }
        );

    }
}
