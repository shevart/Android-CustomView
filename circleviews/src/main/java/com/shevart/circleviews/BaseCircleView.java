package com.shevart.circleviews;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class BaseCircleView extends View {
    protected static final int MAX_VALUE = 100;
    public static final int CIRCLE_INDICATOR_TOP = 1;
    public static final int CIRCLE_INDICATOR_RIGHT = 2;
    public static final int CIRCLE_INDICATOR_BOTTOM = 3;
    public static final int CIRCLE_INDICATOR_LEFT = 4;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({CIRCLE_INDICATOR_TOP, CIRCLE_INDICATOR_RIGHT, CIRCLE_INDICATOR_BOTTOM, CIRCLE_INDICATOR_LEFT})
    public @interface CircleIndicatorStart {
    }

    @BaseCircleView.CircleIndicatorStart
    protected int circleIndicatorStart = CIRCLE_INDICATOR_TOP;

    public BaseCircleView(Context context) {
        super(context);
        init();
    }

    public BaseCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {

    }

    @CircleIndicatorStart
    public int getCircleIndicatorStart() {
        return circleIndicatorStart;
    }

    public void setCircleIndicatorStart(@CircleIndicatorStart int circleIndicatorStart) {
        this.circleIndicatorStart = circleIndicatorStart;
        invalidate(); // review it
    }

    protected int getStartAngleByCircleIndicatorStart(@CircleIndicatorStart int cis) {
        return getCanvasRotateDegreeByCircleIndicatorStart(cis);
    }

    protected int getCanvasRotateDegreeByCircleIndicatorStart(@CircleIndicatorStart int cis) {
        switch (cis) {
            case CIRCLE_INDICATOR_TOP:
                return -90;
            case CIRCLE_INDICATOR_RIGHT:
                return 0;
            case CIRCLE_INDICATOR_BOTTOM:
                return 90;
            case CIRCLE_INDICATOR_LEFT:
                return 180;
            default:
                throw new IllegalArgumentException("Check it!");
        }
    }

    protected void rotateCanvasForCircleIndicator(@NonNull Canvas canvas,
                                                  @CircleIndicatorStart int circleIndicatorStart) {
        canvas.rotate(getCanvasRotateDegreeByCircleIndicatorStart(circleIndicatorStart),
                getWidth() / 2,
                getHeight() / 2);
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    protected float calculateDegreesForArc(float maxValue, float currentValue) {
        float degrees = (360f / maxValue * currentValue);
        return degrees;
    }

    /***
     * Use this method for determine minimal size of view sides.
     * @return minimal side size (width or height)
     */
    protected float getMinSideSize() {
        return getWidth() < getHeight() ? getWidth() : getHeight();
    }
}