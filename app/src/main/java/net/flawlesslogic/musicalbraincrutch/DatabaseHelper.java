package net.flawlesslogic.musicalbraincrutch;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "songs_table";
    private static final String SONG_ID = "ID";
    private static final String SONG_NAME = "song_name";
    private static final String SONG_ARTIST = "song_arist";
    private static final String CAPO_POS = "capo_position";
    private static final String TUNING = "tuning";

    private static final int VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable =
                "CREATE TABLE " + TABLE_NAME + " (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, `" +
                SONG_NAME + "` TEXT,`" +
                SONG_ARTIST +"`TEXT,`" +
                CAPO_POS + "`INTEGER,`" +
                TUNING + "`TEXT" +
                ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SONG_NAME, item);

        Log.d("database", "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}
