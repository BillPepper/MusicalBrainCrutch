package net.flawlesslogic.musicalbraincrutch;

public class MusicEntryFactory {
    public MusicEntry getMusicEntry(int id, String songName, String songArtist, int capoPos, String tuning){
        return new MusicEntry(id, songName, songArtist, capoPos, tuning);
    }
}
