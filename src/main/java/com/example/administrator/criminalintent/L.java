package com.example.administrator.criminalintent;

import android.util.Log;

/**
 * Created by Administrator on 2016/3/1.
 */
public class L {
    private L() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isDebug = true;
    private static final String tag = ">>>";

    public static void i(String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(tag, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.d(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }


    public static void i(String tag, String msg, Exception e) {
        if (isDebug)
            Log.i(tag, msg, e);
    }

    public static void e(String tag, String msg, Exception e) {
        if (isDebug)
            Log.e(tag, msg, e);
    }

    public static void d(String tag, String msg, Exception e) {
        if (isDebug)
            Log.d(tag, msg, e);
    }

    public static void v(String tag, String msg, Exception e) {
        if (isDebug)
            Log.i(tag, msg, e);
    }
}
