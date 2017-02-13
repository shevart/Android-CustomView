package com.shevart.customview.customviews;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.shevart.customview.R;

@SuppressWarnings({"WeakerAccess", "unused"})
public class RatingStarsView extends View {
    private static final int STARS_COUNT = 5;
    private static final int DEFAULT_RATING = 4;

    private Paint paint = new Paint();
    private Rect starRect = new Rect();
    private Bitmap nonActiveStarBitmap, activeStarBitmap;

    private float starWidth = getResources().getDimension(R.dimen.rating_star_width);
    private final float starsPadding = getResources().getDimension(R.dimen.rating_star_padding);
    private float onStarZoneWidth = starWidth + starsPadding;

    private float calculatedRatingBarWidth;
    private float calculatedStartX;

    private int currentRate = DEFAULT_RATING;

    public RatingStarsView(Context context) {
        super(context);
        initView();
    }

    public RatingStarsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public RatingStarsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = (int) starWidth;
        nonActiveStarBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gray_star);
        activeStarBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yellow_star);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        if (eventX < calculatedStartX || eventX > (calculatedStartX + calculatedRatingBarWidth + onStarZoneWidth)) {
            return true;
        }

        eventX -= calculatedStartX; // start from 0
        currentRate = Math.round(eventX / onStarZoneWidth);
        invalidate();

        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateStartX();
    }

    private void calculateStartX() {
        calculatedRatingBarWidth = starWidth * STARS_COUNT + starsPadding * (STARS_COUNT - 1);
        calculatedStartX = getWidth() / 2 - calculatedRatingBarWidth / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float x = calculatedStartX;
        final float startY = (getHeight() / 2) - starWidth / 2;
        for (int i = 0; i < STARS_COUNT; i++) {
            starRect.set((int) x, (int) startY, (int) (x + starWidth), (int) (startY + starWidth));
            if (i < currentRate) {
                canvas.drawBitmap(activeStarBitmap, null, starRect, paint);
            } else {
                canvas.drawBitmap(nonActiveStarBitmap, null, starRect, paint);
            }
            x += starWidth;
            x += starsPadding;
        }
    }
}
