package com.shevart.customview.customviews;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CheckBottomDecorateView extends View {
    private final float countOfTriangles = 25;
    private Paint paint = new Paint();
    private Path path = new Path();

    private float triangleWidth;
    private float oneStep;

    public CheckBottomDecorateView(Context context) {
        super(context);
        init();
    }

    public CheckBottomDecorateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CheckBottomDecorateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (getWidth() != 0) {
            triangleWidth = getWidth() / countOfTriangles;
            oneStep = triangleWidth / 2;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        path.reset();
        path.moveTo(oneStep * -1, 0);

        float lastX = 0;
        for (int i = 0; i <= countOfTriangles; i++) {
            if (i > 0) {
                lastX += oneStep;
            }
            path.lineTo(lastX, oneStep);
            lastX += oneStep;
            path.lineTo(lastX, 0);
        }
        path.close();
        canvas.drawPath(path, paint);
    }
}
