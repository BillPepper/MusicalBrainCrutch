package net.flawlesslogic.musicalbraincrutch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicEntryAdapter extends ArrayAdapter<MusicEntry> {
    MusicEntryAdapter(Context context, ArrayList<MusicEntry> SongEntry) {
        super(context, 0, SongEntry);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MusicEntry musicEntry = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_music_entry, parent, false);
        }

        TextView songName = convertView.findViewById(R.id.tvSongName);
        TextView songArtist = convertView.findViewById(R.id.tvSongArtist);
        TextView capoPosition = convertView.findViewById(R.id.tvCapoPosition);
        TextView tuning = convertView.findViewById(R.id.tvTuning);

        songName.setText(musicEntry.songName);
        songArtist.setText(musicEntry.songArtist);
        capoPosition.setText("Capo: " + Integer.toString(musicEntry.capoPosition));
        tuning.setText(musicEntry.tuning);

        return convertView;
    }



}