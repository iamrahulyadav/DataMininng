package com.example.mohamadhasan.dataminning.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
