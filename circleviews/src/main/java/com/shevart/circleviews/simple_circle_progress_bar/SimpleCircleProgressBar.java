package com.shevart.circleviews.simple_circle_progress_bar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.util.AttributeSet;

import com.shevart.circleviews.BaseCircleView;
import com.shevart.circleviews.utils.UiUtil;

@SuppressWarnings("unused")
public class SimpleCircleProgressBar extends BaseCircleView {
    private RectF circleRectF;
    private Paint circleIndicatorSubstratePaint;
    protected Paint circleActiveIndicatorPaint;
    private float activeCircleStrokeWidth;
    private float substrateCircleStrokeWidth;
    private boolean drawSubstrate = true;

    public SimpleCircleProgressBar(Context context) {
        super(context);
    }

    public SimpleCircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleCircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void init() {
        circleRectF = new RectF();
        circleActiveIndicatorPaint = new Paint();
        circleIndicatorSubstratePaint = new Paint();

        activeCircleStrokeWidth = UiUtil.convertDpToPixel(10, getContext());
        substrateCircleStrokeWidth = activeCircleStrokeWidth;

        circleIndicatorSubstratePaint.setColor(Color.GRAY);
        circleIndicatorSubstratePaint.setStyle(Paint.Style.STROKE);
        circleIndicatorSubstratePaint.setStrokeWidth(substrateCircleStrokeWidth);
        circleIndicatorSubstratePaint.setAntiAlias(true);
        circleIndicatorSubstratePaint.setStrokeCap(Paint.Cap.ROUND);

        circleActiveIndicatorPaint.setColor(Color.YELLOW);
        circleActiveIndicatorPaint.setStyle(Paint.Style.STROKE);
        circleActiveIndicatorPaint.setStrokeWidth(activeCircleStrokeWidth);
        circleActiveIndicatorPaint.setAntiAlias(true);
        circleActiveIndicatorPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    protected void onDraw(Canvas canvas) {
        if (drawSubstrate) {
            // set circles rectF for substrate circle
            circleRectF.set(substrateCircleStrokeWidth, substrateCircleStrokeWidth,
                    getWidth() - substrateCircleStrokeWidth, getHeight() - substrateCircleStrokeWidth);
            // draw substrate circle
            canvas.drawArc(circleRectF, 0, 360, false, circleIndicatorSubstratePaint);
        }

        // set circles rectF for active circle
        circleRectF.set(activeCircleStrokeWidth, activeCircleStrokeWidth,
                getWidth() - activeCircleStrokeWidth, getHeight() - activeCircleStrokeWidth);
        // draw active circle indicator
        canvas.save();
        rotateCanvasForCircleIndicator(canvas, circleIndicatorStart);
        canvas.drawArc(circleRectF, 0, calculateDegreesForArc(100, 75), false, circleActiveIndicatorPaint);
        canvas.restore();
    }

    public float getActiveCircleStrokeWidth() {
        return activeCircleStrokeWidth;
    }

    public void setActiveCircleStrokeWidth(float activeCircleStrokeWidth) {
        this.activeCircleStrokeWidth = activeCircleStrokeWidth;
    }

    public void setActiveCircleStrokeWidth(@DimenRes int dimenResId) {
        this.activeCircleStrokeWidth = getResources().getDimension(dimenResId);
        invalidate();
    }

    public float getSubstrateCircleStrokeWidth() {
        return substrateCircleStrokeWidth;
    }

    public void setSubstrateCircleStrokeWidth(float substrateCircleStrokeWidth) {
        this.substrateCircleStrokeWidth = substrateCircleStrokeWidth;
        invalidate();
    }

    public void setSubstrateCircleStrokeWidth(@DimenRes int dimenResId) {
        this.substrateCircleStrokeWidth = getResources().getDimension(dimenResId);
        invalidate();
    }

    public boolean isDrawSubstrate() {
        return drawSubstrate;
    }

    public void setDrawSubstrate(boolean drawSubstrate) {
        this.drawSubstrate = drawSubstrate;
        invalidate();
    }

    public void setSubstrateCircleColor(@ColorRes int colorResId) {
        circleIndicatorSubstratePaint.setColor(UiUtil.getColor(getContext(), colorResId));
        invalidate();
    }

    public void setActiveCircleColor(@ColorRes int colorResId) {
        circleActiveIndicatorPaint.setColor(UiUtil.getColor(getContext(), colorResId));
        invalidate();
    }
}