package com.shevart.customview.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchCircleView extends View {

    private Paint paint = new Paint();
    private float radius = 0.0f;

    private float x, y;

    public TouchCircleView(Context context) {
        super(context);
    }

    public TouchCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        Log.e(TouchCircleView.class.getSimpleName(), "widthMeasureSpec" + widthMeasureSpec + ", heightMeasureSpec" + heightMeasureSpec);
        Log.e(TouchCircleView.class.getSimpleName(), "getSize(widthMeasureSpec)" + View.MeasureSpec.getSize(widthMeasureSpec) + ", getSize(heightMeasureSpec)" + View.MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        x = w / 2;
        y = h / 2;
        radius = w / 10;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.RED);
        canvas.drawCircle(x, y, radius, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        invalidate();
        return super.onTouchEvent(event);
    }

}
