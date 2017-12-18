package com.example.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.pets.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = "***" + PetDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "shelter.db";
    private static final int DATABASE_VERSION = 1;
    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i(LOG_TAG, "<<constructor>> PetDbHelper()");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_TAG, "onCreate()");
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PetEntry.TABLE_NAME + " ("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                + PetEntry.COLUMN_PET_BREED + " TEXT, "
                + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
                + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(LOG_TAG, "onUpgrade()");    }
}