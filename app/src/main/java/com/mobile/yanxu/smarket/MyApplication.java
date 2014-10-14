package com.mobile.yanxu.smarket;

/**
 * Created by rugangyao on 13/10/2014.
 */
import android.app.Application;
import android.content.Context;

public class MyApplication extends Application
{
    private static Context context;
    public static boolean login = false;
    public static int userID = -1;

    @Override
    public void onCreate()
    {
        context = getApplicationContext();
    }

    public static Context getContextObject()
    {
        return context;
    }
}
