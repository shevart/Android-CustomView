package com.shevart.circleviews.simple_circle_progress_bar;

import android.content.Context;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;

public class DashSimpleCircleProgressBar extends SimpleCircleProgressBar {
    public DashSimpleCircleProgressBar(Context context) {
        super(context);
    }

    public DashSimpleCircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DashSimpleCircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init() {
        super.init();
        circleActiveIndicatorPaint.setStrokeCap(Paint.Cap.SQUARE);
        circleActiveIndicatorPaint.setPathEffect(new DashPathEffect(new float[]{5, 15}, 5));
    }
}
