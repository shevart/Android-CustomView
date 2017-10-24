package com.shevart.customview.screens.circleviewstopic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shevart.customview.R;
import com.shevart.customview.screens.circleviewstopic.simplecircleprogressbar.SimpleCircleProgressBarFragment;
import com.shevart.customview.utils.FragmentUtil;

public class CircleViewsTopicDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_views_topic_demo);

        // todo remove after test
        FragmentUtil.replaceFragment(getSupportFragmentManager(),
                new SimpleCircleProgressBarFragment(), R.id.flCircleViewContainer);
    }
}
