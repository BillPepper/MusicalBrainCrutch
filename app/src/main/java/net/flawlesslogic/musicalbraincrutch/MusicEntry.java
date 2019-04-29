package net.flawlesslogic.musicalbraincrutch;

public class MusicEntry {
    int index;
    String songName;
    String songArtist;
    int capoPosition;
    String tuning;

    public MusicEntry(int index, String songName, String songArtist, int capoPosition, String tuning) {
        this.index = index;
        this.songName = songName;
        this.songArtist = songArtist;
        this.capoPosition = capoPosition;
        this.tuning = tuning;
    }
}
