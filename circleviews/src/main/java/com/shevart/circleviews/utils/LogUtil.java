package com.shevart.circleviews.utils;

import android.support.annotation.NonNull;
import android.util.Log;

public class LogUtil {
    private static final boolean DEBUG = true;
    private static final String TAG = "<-- CircleViews -->";

    public static void logE(@NonNull String e) {
        if (DEBUG)
            Log.e(TAG, e);
    }
}
