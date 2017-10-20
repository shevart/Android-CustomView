package com.shevart.circleviews.triple_circle_progress_bar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.shevart.circleviews.BaseCircleView;
import com.shevart.circleviews.utils.UiUtil;

public class TripleCircleProgressBar extends BaseCircleView {
    private float circleWidth;
    private float circlePadding;
    private Paint topCirclePaint;
    private Paint mediumCirclePaint;
    private Paint bottomCirclePaint;
    private RectF circleRectF; // todo use one rectF for each circle
    private int topCircleColor;
    private int topSubstrateCircleColor;
    private int mediumCircleColor;
    private int mediumSubstrateCircleColor;
    private int bottomCircleColor;
    private int bottomSubstrateCircleColor;


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
        circleWidth = UiUtil.convertDpToPixel(10, getContext());
        circlePadding = UiUtil.convertDpToPixel(1, getContext());

        topCircleColor = Color.RED;
        topSubstrateCircleColor = Color.GRAY;
        mediumCircleColor = Color.GREEN;
        mediumSubstrateCircleColor = Color.GRAY;
        bottomCircleColor = Color.YELLOW;
        bottomSubstrateCircleColor = Color.GRAY;

        circleRectF = new RectF();
        topCirclePaint = new Paint();
        mediumCirclePaint = new Paint();
        bottomCirclePaint = new Paint();
        setGeneralCirclePaintParams(topCirclePaint);
        setGeneralCirclePaintParams(mediumCirclePaint);
        setGeneralCirclePaintParams(bottomCirclePaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }


    private void setGeneralCirclePaintParams(@NonNull Paint circlePaint) {
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeCap(Paint.Cap.ROUND);
        circlePaint.setStrokeWidth(circleWidth);
    }
}