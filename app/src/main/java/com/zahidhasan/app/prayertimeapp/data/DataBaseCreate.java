package com.zahidhasan.app.prayertimeapp.data;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

/**
 * Created by DarkzGothic on 8/28/2017.
 */

public class DataBaseCreate {

    private DataBaseCreateHandler dbHandler;
    private SQLiteDatabase db;

    public DataBaseCreate(Context context) {
        dbHandler = new DataBaseCreateHandler(context);
    }

    public DataBaseCreate createDataBase() throws SQLException {
        try {
            dbHandler.createDataBase();
        }catch (IOException exception){
            exception.printStackTrace();
        }
        return this;
    }

    public DataBaseCreate open() throws SQLException {
        try{
            dbHandler.openDataBase();
            dbHandler.close();
            db = dbHandler.getReadableDatabase();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return this;
    }

    public void close(){
        dbHandler.close();
    }
}
