package com.xavien.utils;

import android.util.Log;

import com.xavien.demo.BuildConfig;

/**
 * Created by Xavien on 15-3-31.
 */
public class XLog {

    public static void i(String TAG, String msg){
        if(BuildConfig.DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public  static void e(String TAG, String msg){
        if(BuildConfig.DEBUG){
            Log.e(TAG, msg);
        }
    }
}
