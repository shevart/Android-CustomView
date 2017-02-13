package com.shevart.customview.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.shevart.customview.R;

public class ViewPagerPagesIndicatorView extends View {
    private int currentPageNumber = 1;
    private int pagesCount = 5;

    private Paint paintActiveDot = new Paint();
    private Paint paintDot = new Paint();

    private int activeBitmapSideSize, nonActiveBitmapSideSize, dotsPadding;

    public ViewPagerPagesIndicatorView(Context context) {
        super(context);
        init();
    }

    public ViewPagerPagesIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViewPagerPagesIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        activeBitmapSideSize = (int) (getResources().getDimension(R.dimen.active_indicator_side_size) / getResources().getDisplayMetrics().density);
        nonActiveBitmapSideSize = (int) (getResources().getDimension(R.dimen.no_active_indicator_side_size) / getResources().getDisplayMetrics().density);
        dotsPadding = (int) (getResources().getDimension(R.dimen.vp_indicators_padding) / getResources().getDisplayMetrics().density);

        paintActiveDot.setColor(Color.WHITE);
        paintActiveDot.setStyle(Paint.Style.FILL);
        paintActiveDot.setAntiAlias(true);
        paintActiveDot.setAlpha(120);
        paintDot.setColor(Color.WHITE);
        paintDot.setStyle(Paint.Style.FILL);
        paintDot.setAlpha(75);
        paintDot.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float topX = getStartX();
        final int topY = getHeight() / 2;

        for (int i = 0; i < pagesCount; i++) {
            if (i == currentPageNumber) {
                canvas.drawCircle(topX, topY, activeBitmapSideSize, paintActiveDot);
            } else {
                canvas.drawCircle(topX, topY, nonActiveBitmapSideSize, paintDot);
            }
            topX += activeBitmapSideSize * 3;
        }
    }

    private float getStartX() {
        float startX = getWidth() / 2;
        startX -= ((activeBitmapSideSize * 2) * pagesCount) / 2 - activeBitmapSideSize;
        return startX;
    }
}
