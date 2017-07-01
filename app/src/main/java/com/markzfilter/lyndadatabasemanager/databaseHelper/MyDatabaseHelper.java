package com.markzfilter.lyndadatabasemanager.databaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mark Filter on 7/1/17.
 * Code was obtained via https://gist.github.com/davidgassner/17304aa986ec3c146534
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "people";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE =
            "CREATE TABLE " + MyDataSource.PEOPLE_TABLE + " ("
                    + MyDataSource.PERSON_ID + " INTEGER PRIMARY KEY, "
                    + MyDataSource.PERSON_NAME + " TEXT NOT NULL);";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + MyDataSource.PEOPLE_TABLE);
        onCreate(database);
    }
}
