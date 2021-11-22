package com.example.corona19app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.sql.SQLException;

public class DbOpenHelper {

    private static final String DATABASE_NAME = "InnerDataBase(SQLite).db";

    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory Object o, int version) {
            super(context , name , factory , version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DataBases.CreateDB._CREATE0);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS "+DataBases.CreateDB._TABLENAME0);
            onCreate(db);
        }
    }
    public DbOpenHelper(Context context){
        this.mCtx = context;
    }

    public DbOpenHelper open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME,null,DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void create(){
        mDBHelper.onCreate(mDB);
    }

    public void close(){
        mDB.close();
    }
}
    public long insertColumn(String userid, String name, long age , long birthday , long phone , long password){
        ContentValues values = new ContentValues();
        values.put(DataBases.CreateDB.USERID, userid);
        values.put(DataBases.CreateDB.NAME, name);
        values.put(DataBases.CreateDB.AGE, age);
        values.put(DataBases.CreateDB.Birthday, birthday);
        values.put(DataBases.CreateDB.PHONE, phone);
        values.put(DataBases.CreateDB.PASSWORD, password);
        return mDB.insert(DataBases.CreateDB._TABLENAME0, null, values);
    }
}
