package com.xavien.utils;

import android.util.Log;

/**
 * Created by Xavien on 15-3-31.
 */
public class XLog {

    private static final boolean DEBUG = true;

    public static void i(String TAG, String msg){
        if(DEBUG) {
            Log.i(TAG, msg);
        }
    }
}
