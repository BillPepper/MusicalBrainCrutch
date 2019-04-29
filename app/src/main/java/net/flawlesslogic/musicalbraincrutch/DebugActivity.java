package net.flawlesslogic.musicalbraincrutch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class DebugActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        String songName = getIntent().getStringExtra("songName");
        String songArtist = getIntent().getStringExtra("songArtist");

        TextView x = findViewById(R.id.tvDebug);
        x.setText(getString(R.string.youSelectedText, songName, songArtist));
    }
}
