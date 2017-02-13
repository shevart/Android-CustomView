package com.shevart.customview.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ThreeCirclesView extends View {

    private Paint paint = new Paint();

    public ThreeCirclesView(Context context) {
        super(context);
    }

    public ThreeCirclesView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThreeCirclesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);

        paint.setColor(Color.RED);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, calculateRadius(30), paint);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, calculateRadius(20), paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, calculateRadius(10), paint);
    }

    private float calculateRadius(int percentsOfWidth) {
        return (getWidth() / 100) * percentsOfWidth;
    }
}
