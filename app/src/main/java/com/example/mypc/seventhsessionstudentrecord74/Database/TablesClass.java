package com.example.mypc.seventhsessionstudentrecord74.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mypc.seventhsessionstudentrecord74.Utils.Constants;

/**
 * Created by my pc on 4/5/2017.
 */

public class TablesClass extends SQLiteOpenHelper {
    Context context;

    public TablesClass(Context context, String DatabaseName, String nullColumnHack, int databaseVersion) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1 = "CREATE TABLE IF NOT EXISTS " + Constants.STUDENT_RECORD + " ("
                + Constants.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Constants.FIRST_NAME + " TEXT, "
                + Constants.LAST_NAME + " TEXT) ";

        db.execSQL(table1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        context.deleteDatabase(Constants.DATABASE_NAME);
        onCreate(db);
    }
}
