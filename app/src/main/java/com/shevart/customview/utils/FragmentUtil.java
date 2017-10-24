package com.shevart.customview.utils;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

@SuppressWarnings({"WeakerAccess"})
public class FragmentUtil {
    /*
     * Common methods
     */
    public static void replaceFragment(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment,
                                       @IdRes int containerId) {
        fragmentManager
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    public static void replaceFragment(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment,
                                       @IdRes int containerId,
                                       boolean backStack) {
        final FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction()
                .replace(containerId, fragment);
        if (backStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static void addFragment(@NonNull FragmentManager fragmentManager,
                                   @NonNull Fragment fragment,
                                   @IdRes int containerId) {
        addFragment(fragmentManager, fragment, containerId, false);
    }

    public static void addFragment(@NonNull FragmentManager fragmentManager,
                                   @NonNull Fragment fragment,
                                   @IdRes int containerId,
                                   boolean stackTrace) {
        final FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction()
                .add(containerId, fragment);
        if (stackTrace)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static void removeFragment(@NonNull FragmentManager fragmentManager,
                                      @NonNull Fragment fragment) {
        removeFragment(fragmentManager, fragment, false);
    }

    public static void removeFragment(@NonNull FragmentManager fragmentManager,
                                      @NonNull Fragment fragment,
                                      boolean stackTrace) {
        final FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction()
                .remove(fragment);
        if (stackTrace)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
