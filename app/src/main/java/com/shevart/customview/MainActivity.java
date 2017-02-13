package com.shevart.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shevart.customview.customviews.UserProgressCircle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int delay = 0;
        for (int i = 0; i < 35; i++) {
            findViewById(R.id.activity_main).postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateProgress(1 + new Random().nextInt(98));
                }
            }, delay);
            delay += 2100;
        }
    }

    private void updateProgress(int progress) {
        ((UserProgressCircle) findViewById(R.id.progressCircle)).setCurrentValue(progress, true);
    }
}
