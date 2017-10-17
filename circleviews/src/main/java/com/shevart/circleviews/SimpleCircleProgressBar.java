package com.shevart.circleviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.shevart.circleviews.utils.UiUtil;

public class SimpleCircleProgressBar extends View {
    private RectF circleRectF = new RectF();
    private Paint circlePaint = new Paint();
    private float circleStrokeWidth;

    public SimpleCircleProgressBar(Context context) {
        super(context);
        init();
    }

    public SimpleCircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleCircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        circleStrokeWidth = UiUtil.convertDpToPixel(10, getContext());

        circlePaint.setColor(Color.YELLOW);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(circleStrokeWidth);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeCap(Paint.Cap.ROUND);

    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    protected void onDraw(Canvas canvas) {

        // draw active circle indicator
        canvas.save();
        canvas.rotate(-90, getWidth() / 2, getHeight() / 2);
        circleRectF.set(circleStrokeWidth, circleStrokeWidth,
                getWidth() - circleStrokeWidth, getHeight() - circleStrokeWidth);
        canvas.drawArc(circleRectF, 0, 111, false, circlePaint);
        canvas.restore();
    }
}