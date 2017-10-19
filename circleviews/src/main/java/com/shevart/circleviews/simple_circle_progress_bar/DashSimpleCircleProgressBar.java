package com.shevart.circleviews.simple_circle_progress_bar;

import android.content.Context;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.shevart.circleviews.utils.UiUtil;

@SuppressWarnings("unused")
public class DashSimpleCircleProgressBar extends SimpleCircleProgressBar {
    private float activeCircleDashSectionWidth;
    private float activeCircleDashSpaceWidth;

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
        activeCircleDashSectionWidth = UiUtil.convertDpToPixel(1, getContext());
        activeCircleDashSpaceWidth = UiUtil.convertDpToPixel(3, getContext());
        initDashEffect();
    }

    private void initDashEffect() {
        circleActiveIndicatorPaint.setStrokeCap(Paint.Cap.BUTT);
        circleActiveIndicatorPaint.setPathEffect(
                new DashPathEffect(new float[]{activeCircleDashSectionWidth, activeCircleDashSpaceWidth}, 1));
        invalidate();
    }

    public float getActiveCircleDashSectionWidth() {
        return activeCircleDashSectionWidth;
    }

    public void setActiveCircleDashSectionWidth(float activeCircleDashSectionWidth) {
        this.activeCircleDashSectionWidth = activeCircleDashSectionWidth;
        initDashEffect();
    }

    public float getActiveCircleDashSpaceWidth() {
        return activeCircleDashSpaceWidth;
    }

    public void setActiveCircleDashSpaceWidth(float activeCircleDashSpaceWidth) {
        this.activeCircleDashSpaceWidth = activeCircleDashSpaceWidth;
        initDashEffect();
    }
}