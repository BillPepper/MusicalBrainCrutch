package net.flawlesslogic.musicalbraincrutch;

public class MusicEntry {
    String songName;
    String songArtist;
    int capoPosition;
    String tuning;

    public MusicEntry(String songName, String songArtist, int capoPosition, String tuning) {
        this.songName = songName;
        this.songArtist = songArtist;
        this.capoPosition = capoPosition;
        this.tuning = tuning;
    }
}
