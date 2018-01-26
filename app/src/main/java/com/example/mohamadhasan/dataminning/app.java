package com.example.mohamadhasan.dataminning;

import android.app.Application;
import android.content.Context;

import com.example.mohamadhasan.dataminning.db.IOHelper;

/**
 * Created by mohamadHasan on 22/11/2017.
 */

public class app extends Application {


    public static Context context;

        @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        IOHelper.transferDatabaseFile(context);
    }
}
