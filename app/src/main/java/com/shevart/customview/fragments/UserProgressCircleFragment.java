package com.shevart.customview.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shevart.customview.R;
import com.shevart.customview.customviews.UserProgressCircle;

import java.util.Random;


public class UserProgressCircleFragment extends Fragment {
    private Handler handler = new Handler(Looper.getMainLooper());
    private UserProgressCircle userProgressCircle;


    public UserProgressCircleFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.fragment_user_progress_circle, container, false);
        userProgressCircle = (UserProgressCircle) view.findViewById(R.id.progressCircle);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        generateUserProgressCircleFakeUpdateEvents();
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null);
    }

    private void generateUserProgressCircleFakeUpdateEvents() {
        int delay = 0;
        for (int i = 0; i < 35; i++) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateProgress(1 + new Random().nextInt(98));
                }
            }, delay);
            delay += 2100;
        }
    }

    private void updateProgress(int progress) {
        userProgressCircle.setCurrentValue(progress, true);
    }


}
