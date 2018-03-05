package com.zahidhasan.app.prayertimeapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zahidhasan.app.prayertimeapp.model.Hadith;

import java.util.ArrayList;

/**
 * Created by DarkzGothic on 8/28/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private final ArrayList<Hadith> hadiths = new ArrayList<>();

    public DataBaseHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    public ArrayList<Hadith> getHadiths(){

        hadiths.clear();

        String query = "SELECT * FROM " + Constants.TABLE_Hadith;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do {
                Hadith hadith = new Hadith();
                hadith.setId(cursor.getInt(cursor.getColumnIndex(Constants.HADITH_ID)));
                hadith.setTitle(cursor.getString(cursor.getColumnIndex(Constants.HADITH_TITLE)));
                hadith.setInBangla(cursor.getString(cursor.getColumnIndex(Constants.HADITH_IN_BANGLA)));
                hadith.setInEnglish(cursor.getString(cursor.getColumnIndex(Constants.HADITH_IN_ENGLISH)));
                hadith.setInArabic(cursor.getString(cursor.getColumnIndex(Constants.HADITH_IN_ARABIC)));

                hadiths.add(hadith);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return hadiths;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
