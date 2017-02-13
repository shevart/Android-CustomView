package com.shevart.customview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.shevart.customview.customviews.UserProgressCircle;

import java.util.Random;

public class MainActivity extends Activity {
    private Handler handler = new Handler(Looper.getMainLooper());

    private UserProgressCircle userProgressCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userProgressCircle = (UserProgressCircle) findViewById(R.id.progressCircle);
    }

    @Override
    protected void onResume() {
        super.onResume();

        generateUserProgressCircleFakeUpdateEvents();
    }

    @Override
    protected void onPause() {
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
