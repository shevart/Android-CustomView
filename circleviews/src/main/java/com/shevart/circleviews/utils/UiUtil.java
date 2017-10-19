package com.shevart.circleviews.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

@SuppressWarnings({"UnnecessaryLocalVariable", "unused"})
public class UiUtil {

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * Code from: https://stackoverflow.com/questions/4605527/converting-pixels-to-dp
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, @NonNull Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * Code from: https://stackoverflow.com/questions/4605527/converting-pixels-to-dp
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, @NonNull Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public static int getColor(@NonNull Context context, @ColorRes int colorResId) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            return context.getResources().getColor(colorResId);
        } else {
            return context.getResources().getColor(colorResId, null);
        }
    }
}
