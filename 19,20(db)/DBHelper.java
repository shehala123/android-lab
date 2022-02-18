package com.example.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DEMO.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TBL_PERSONS= "persons";
    public static final String PERSON_ID= "id";
    public static final String PERSON_FNAME= "first_name";
    public static final String PERSON_LNAME= "last_name";
    public static final String PERSON_GENDER= "gender";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table "+TBL_PERSONS +
                        "("+PERSON_ID+" integer primary key AUTOINCREMENT,"+PERSON_FNAME+" text,"+PERSON_LNAME+" text,"+PERSON_GENDER+" text)"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    long insertData(String fName,String lName,String gender)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PERSON_FNAME,fName);
        contentValues.put(PERSON_LNAME,lName);
        contentValues.put(PERSON_GENDER,gender);

        return db.insert(TBL_PERSONS,null,contentValues);
    }

    Cursor getData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TBL_PERSONS, null);
        return res;
    }

    int update(int id,String fName,String lName,String gender)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(PERSON_FNAME,fName);
        contentValues.put(PERSON_LNAME,lName);
        contentValues.put(PERSON_GENDER,gender);
        return db.update(TBL_PERSONS,contentValues,"id = ? ",new String[] { Integer.toString(id) } );

    }

    int delete(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TBL_PERSONS,"id = ? ",new String[] { Integer.toString(id) });
    }

}
