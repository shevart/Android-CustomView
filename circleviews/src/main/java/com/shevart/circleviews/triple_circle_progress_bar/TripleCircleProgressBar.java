package com.shevart.circleviews.triple_circle_progress_bar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.shevart.circleviews.BaseCircleView;
import com.shevart.circleviews.utils.UiUtil;

@SuppressWarnings("unused")
public class TripleCircleProgressBar extends BaseCircleView {
    private float circleWidth;
    private float circlePadding;
    private Paint topCirclePaint;
    private Paint middleCirclePaint;
    private Paint bottomCirclePaint;
    private RectF circleRectF;
    private int topCircleColor;
    private int topSubstrateCircleColor;
    private int middleCircleColor;
    private int middleSubstrateCircleColor;
    private int bottomCircleColor;
    private int bottomSubstrateCircleColor;
    private boolean drawSubstrate = true;

    private int topCircleValue = 75;
    private int middleCircleValue = 45;
    private int bottomCircleValue = 25;

    public TripleCircleProgressBar(Context context) {
        super(context);
    }

    public TripleCircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TripleCircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init() {
        super.init();
        circleWidth = UiUtil.convertDpToPixel(12, getContext());
        circlePadding = UiUtil.convertDpToPixel(1.5f, getContext());

        topCircleColor = Color.GREEN;
        topSubstrateCircleColor = Color.GRAY;
        middleCircleColor = Color.YELLOW;
        middleSubstrateCircleColor = Color.GRAY;
        bottomCircleColor = Color.RED;
        bottomSubstrateCircleColor = Color.GRAY;

        circleRectF = new RectF();
        topCirclePaint = new Paint();
        middleCirclePaint = new Paint();
        bottomCirclePaint = new Paint();
        setGeneralCirclePaintParams(topCirclePaint);
        setGeneralCirclePaintParams(middleCirclePaint);
        setGeneralCirclePaintParams(bottomCirclePaint);
    }

    private void setGeneralCirclePaintParams(@NonNull Paint circlePaint) {
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeCap(Paint.Cap.ROUND);
        circlePaint.setStrokeWidth(circleWidth);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    protected void onDraw(Canvas canvas) {
        final float minSideSize = getMinSideSize();

        // --- draw top circle

        // set rectF for top circle
        circleRectF.set(circleWidth, circleWidth,
                minSideSize - circleWidth, minSideSize - circleWidth);
        // draw substrate circle if need
        if (drawSubstrate) {
            topCirclePaint.setColor(topSubstrateCircleColor);
            // draw substrate
            canvas.drawArc(circleRectF, 0, 360, false, topCirclePaint);
        }
        // draw active circle
        topCirclePaint.setColor(topCircleColor);
        canvas.drawArc(circleRectF, getStartAngleByCircleIndicatorStart(circleIndicatorStart),
                calculateDegreesForArc(MAX_VALUE, topCircleValue), false, topCirclePaint);

        // --- draw middle circle

        // set rectF for top circle
        final float middleCirclePadding = circleWidth * 2 + circlePadding;
        circleRectF.set(middleCirclePadding, middleCirclePadding,
                minSideSize - middleCirclePadding, minSideSize - middleCirclePadding);
        // draw substrate circle if need
        if (drawSubstrate) {
            middleCirclePaint.setColor(middleSubstrateCircleColor);
            // draw substrate
            canvas.drawArc(circleRectF, 0, 360, false, middleCirclePaint);
        }
        // draw active circle
        middleCirclePaint.setColor(middleCircleColor);
        canvas.drawArc(circleRectF, getStartAngleByCircleIndicatorStart(circleIndicatorStart),
                calculateDegreesForArc(MAX_VALUE, middleCircleValue), false, middleCirclePaint);

        // --- draw bottom circle

        // set rectF for top circle
        float bottomCirclePadding = circleWidth * 3 + circlePadding * 2;
        circleRectF.set(bottomCirclePadding, bottomCirclePadding,
                minSideSize - bottomCirclePadding, minSideSize - bottomCirclePadding);
        // draw substrate circle if need
        if (drawSubstrate) {
            bottomCirclePaint.setColor(bottomSubstrateCircleColor);
            // draw substrate
            canvas.drawArc(circleRectF, 0, 360, false, bottomCirclePaint);
        }
        // draw active circle
        bottomCirclePaint.setColor(bottomCircleColor);
        canvas.drawArc(circleRectF, getStartAngleByCircleIndicatorStart(circleIndicatorStart),
                calculateDegreesForArc(MAX_VALUE, bottomCircleValue), false, bottomCirclePaint);
    }

    public float getCircleWidth() {
        return circleWidth;
    }

    public void setCircleWidth(float circleWidth) {
        this.circleWidth = circleWidth;
        invalidate();
    }

    public void setCircleWidth(@DimenRes int dimenResId) {
        this.circleWidth = getResources().getDimension(dimenResId);
        invalidate();
    }

    public float getCirclePadding() {
        return circlePadding;
    }

    public void setCirclePadding(float circlePadding) {
        this.circlePadding = circlePadding;
        invalidate();
    }

    public void setCirclePadding(@DimenRes int dimenResId) {
        this.circlePadding = getResources().getDimension(dimenResId);
        invalidate();
    }

    public int getTopCircleValue() {
        return topCircleValue;
    }

    public void setTopCircleValue(int topCircleValue) {
        this.topCircleValue = topCircleValue;
        invalidate();
    }

    public int getMiddleCircleValue() {
        return middleCircleValue;
    }

    public void setMiddleCircleValue(int middleCircleValue) {
        this.middleCircleValue = middleCircleValue;
        invalidate();
    }

    public int getBottomCircleValue() {
        return bottomCircleValue;
    }

    public void setBottomCircleValue(int bottomCircleValue) {
        this.bottomCircleValue = bottomCircleValue;
        invalidate();
    }

    public void setTripleCircleValues(int topCircleValue, int middleCircleValue, int bottomCircleValue) {
        this.topCircleValue = topCircleValue;
        this.middleCircleValue = middleCircleValue;
        this.bottomCircleValue = bottomCircleValue;
        invalidate();
    }

    public boolean isDrawSubstrate() {
        return drawSubstrate;
    }

    public void setDrawSubstrate(boolean drawSubstrate) {
        this.drawSubstrate = drawSubstrate;
        invalidate();
    }

    public int getTopCircleColor() {
        return topCircleColor;
    }

    public void setTopCircleColor(int topCircleColor) {
        this.topCircleColor = topCircleColor;
        invalidate();
    }

    public int getTopSubstrateCircleColor() {
        return topSubstrateCircleColor;
    }

    public void setTopSubstrateCircleColor(int topSubstrateCircleColor) {
        this.topSubstrateCircleColor = topSubstrateCircleColor;
        invalidate();
    }

    public int getMiddleCircleColor() {
        return middleCircleColor;
    }

    public void setMiddleCircleColor(int middleCircleColor) {
        this.middleCircleColor = middleCircleColor;
        invalidate();
    }

    public int getMiddleSubstrateCircleColor() {
        return middleSubstrateCircleColor;
    }

    public void setMiddleSubstrateCircleColor(int middleSubstrateCircleColor) {
        this.middleSubstrateCircleColor = middleSubstrateCircleColor;
        invalidate();
    }

    public int getBottomCircleColor() {
        return bottomCircleColor;
    }

    public void setBottomCircleColor(int bottomCircleColor) {
        this.bottomCircleColor = bottomCircleColor;
        invalidate();
    }

    public int getBottomSubstrateCircleColor() {
        return bottomSubstrateCircleColor;
    }

    public void setBottomSubstrateCircleColor(int bottomSubstrateCircleColor) {
        this.bottomSubstrateCircleColor = bottomSubstrateCircleColor;
        invalidate();
    }

    public void setActiveCirclesColors(int topCircleColor, int middleCircleColor, int bottomCircleColor) {
        this.topCircleColor = topCircleColor;
        this.middleCircleColor = middleCircleColor;
        this.bottomCircleColor = bottomCircleColor;
        invalidate();
    }

    public void setSubstrateCirclesColors(int topSubstrateCircleColor,
                                          int middleSubstrateCircleColor,
                                          int bottomSubstrateCircleColor) {
        this.topSubstrateCircleColor = topSubstrateCircleColor;
        this.middleSubstrateCircleColor = middleSubstrateCircleColor;
        this.bottomSubstrateCircleColor = bottomSubstrateCircleColor;
        invalidate();
    }
}