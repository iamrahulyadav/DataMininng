package com.example.mohamadhasan.dataminning.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EHSAN on 11/29/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, IOHelper.DATA_DIRECTORY + IOHelper.DATABASE_FILE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insertNewUser(String name, String pass) {

        SQLiteDatabase DataDB = getReadableDatabase();
        String sql = "";

        String add = "INSERT INTO tbl_user (name,pass,Action,Adventure,Animation,Children,Comedy,Fantasy,IMAX,Romance,Sci_Fi,Western,Mystery,Crime,Drama,Horror,Thriller,Film_Noir,Ducumentary,War,Musical) VALUES('" + name + "' , '" + pass + "' , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+" , "+0+")";

//        sql = "INSERT INTO tbl_user (name,pass,Action,Adventure,Animation,Children,Comedy,Fantasy,IMAX,Romance,Sci-Fi,Western,Mystery,Crime,Drama,Horror,Thriller,Film-Noir,Ducumentary,War,Musical) VALUES('"
//                + name + "','" + pass + "','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0')";
        DataDB.execSQL(add);
        DataDB.close();
    }

    public List<String> selecUser(String name, String pass) {
        List<String> list = new ArrayList<>();
        SQLiteDatabase DataDB = getReadableDatabase();
        String sql = "SELECT * FROM tbl_user WHERE name='" + name + "' AND pass=" + pass;
        String request = "name";
        Cursor cursor = DataDB.rawQuery(sql, null);
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                String s = cursor.getString(cursor.getColumnIndex(request));
                list.add(s);
            } while (cursor.moveToNext());

        }
        cursor.close();
        DataDB.close();
        return list;
    }

    public void updateTbl_user(double[] userRating, String name, String pass) {

        SQLiteDatabase DataDB = getReadableDatabase();
        String sql;
        sql = "UPDATE tbl_user SET Action=" + userRating[0] + ",Adventure=" + userRating[1] + ",Animation=" + userRating[2] + ",Children=" + userRating[3] + ",Comedy=" + userRating[4] + ",Fantasy=" + userRating[5] + ",IMAX=" + userRating[6] + ",Romance=" + userRating[7] + ",Sci_Fi=" + userRating[8] + ",Western=" + userRating[9] + ",Mystery=" + userRating[10] + ",Crime=" + userRating[11] + ",Drama=" + userRating[12] + ",Horror=" + userRating[13] + ",Thriller=" + userRating[14] + ",Film_Noir=" + userRating[15] + ",Ducumentary=" + userRating[16] + ",War=" + userRating[17] + ",Musical=" + userRating[18] + " WHERE name='" + name + "' AND pass=" + pass;
        DataDB.execSQL(sql);
        DataDB.close();
    }

}
