package com.shevart.customview.screens.circleviewstopic.simplecircleprogressbar;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.SeekBar;

import com.shevart.circleviews.simple_circle_progress_bar.SimpleCircleProgressBar;
import com.shevart.customview.R;
import com.shevart.customview.customviews.BaseFragment;

public class SimpleCircleProgressBarFragment extends BaseFragment {
    private SimpleCircleProgressBar simpleCircleProgressBar;
    private SeekBar sbValue;

    public SimpleCircleProgressBarFragment() {
    }

    @Override
    protected int provideLayoutResId() {
        return R.layout.fragment_simple_circle_progress_bar;
    }

    @Override
    protected void bindView(@NonNull View view) {
        simpleCircleProgressBar = view.findViewById(R.id.simpleCircleProgressBar);
        sbValue = view.findViewById(R.id.sbValue);
        sbValue.setMax(100);
        sbValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                simpleCircleProgressBar.setCurrentValue(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}