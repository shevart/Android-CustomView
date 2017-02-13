package com.shevart.customview.customviews;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import com.shevart.customview.R;

public class UserProgressCircle extends View {
    private static final int SET_CURRENT_VALUE = 1;
    private static final int ANIMATE_DELAY = 15;
    private static final float ANIMATE_STEPS = 40f;
    private Paint paintGradientArc = new Paint();
    private Paint paintGreyCircle = new Paint();
    private Paint paintHintPoint = new Paint();
    private Paint paintHintPointStroke = new Paint();

    private SweepGradient userProgressGradient;

    private RectF gradientArcRectF = new RectF();
    private RectF greyCircleRectF = new RectF();

    private Handler animateHandler;
    private boolean isAnimateRunning = false;

    private float maxValue = 100;
    private float currentValue = 2;

    private float greyCircleWidth;
    private float gradientCircleWidth;

    private int[] colorsGradient;

    public UserProgressCircle(Context context) {
        super(context);
        init();
    }

    public UserProgressCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UserProgressCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setCurrentValue(int currentValue, boolean animate) {
        if (currentValue > maxValue)
            throw new RuntimeException("Current value cannot be bigger than maxValue!");

        if (isAnimateRunning) {
            stopCurrentAnimate();
        }

        if (!animate) {
            setAndShowCurrentValue(currentValue);
        } else {
            setAndStartAnimate(currentValue);
        }
    }

    private void stopCurrentAnimate() {
        animateHandler.removeCallbacksAndMessages(null);
    }

    private void setAndShowCurrentValue(int currentValue) {
        this.currentValue = currentValue;
        invalidate();
    }

    private void setAndStartAnimate(int currentValue) {
        final float oneValueStep = (currentValue - this.currentValue) / ANIMATE_STEPS;
        int delay = 0;
        float tempAnimateValue = this.currentValue;
        for (int i = 0; i < ANIMATE_STEPS; i++) {
            delay += ANIMATE_DELAY;
            tempAnimateValue += oneValueStep;
            Message message = animateHandler.obtainMessage(SET_CURRENT_VALUE, (int) tempAnimateValue, 0);
            animateHandler.sendMessageDelayed(message, delay);
        }
        // last message
        Message message = animateHandler.obtainMessage(SET_CURRENT_VALUE, currentValue, 0);
        animateHandler.sendMessageDelayed(message, delay + ANIMATE_DELAY);
    }

    private void init() {
        initHandler();
        greyCircleWidth = getResources().getDimensionPixelSize(R.dimen.user_progress_circle_grey_stroke);
        gradientCircleWidth = getResources().getDimensionPixelSize(R.dimen.user_progress_circle_gradient_stroke);

        paintGreyCircle.setColor(getResources().getColor(R.color.user_progress_circle_grey));
        paintGreyCircle.setStyle(Paint.Style.STROKE);
        paintGreyCircle.setStrokeWidth(greyCircleWidth);
        paintGreyCircle.setAntiAlias(true);

        paintGradientArc.setStyle(Paint.Style.STROKE);
        paintGradientArc.setColor(Color.WHITE);
        paintGradientArc.setStrokeWidth(gradientCircleWidth);
        paintGradientArc.setAntiAlias(true);
        paintGradientArc.setStrokeCap(Paint.Cap.ROUND);

        paintHintPoint.setAntiAlias(true);

        paintHintPointStroke.setAntiAlias(true);
        paintHintPointStroke.setStyle(Paint.Style.STROKE);
        paintHintPointStroke.setColor(getResources().getColor(R.color.user_progress_circle_grey));
        paintHintPointStroke.setStrokeWidth((greyCircleWidth - gradientCircleWidth) * 1.4f);

        colorsGradient = new int[3];
        colorsGradient[0] = getResources().getColor(R.color.user_progress_circle_start_color);
        colorsGradient[1] = getResources().getColor(R.color.user_progress_circle_medium_color);
        colorsGradient[2] = getResources().getColor(R.color.user_progress_circle_end_color);
    }

    private void initHandler() {
        animateHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == SET_CURRENT_VALUE) {
                    setAndShowCurrentValue(msg.arg1);
                }
            }
        };
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        initUserProgressGradient();
    }

    private void initUserProgressGradient() {
        if (getWidth() != 0) {
            userProgressGradient = new SweepGradient(getWidth() / 2, getHeight() / 2, colorsGradient, null);
            paintGradientArc.setShader(userProgressGradient);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (userProgressGradient == null) initUserProgressGradient();

        greyCircleRectF.set(greyCircleWidth, greyCircleWidth, getWidth() - greyCircleWidth, getHeight() - greyCircleWidth);
        canvas.drawArc(greyCircleRectF, 0, 360, false, paintGreyCircle);
        canvas.save();

        canvas.rotate(-90, getWidth() / 2, getHeight() / 2);
        gradientArcRectF.set(greyCircleWidth, greyCircleWidth, getWidth() - greyCircleWidth, getHeight() - greyCircleWidth);
        canvas.drawArc(greyCircleRectF, 0, calculateDegreesForArc(), false, paintGradientArc);
        canvas.restore();

        // draw 1 point
        paintHintPoint.setColor(colorsGradient[2]);
        canvas.drawCircle(getWidth() / 2, greyCircleWidth, greyCircleWidth / 2, paintHintPointStroke);
        canvas.drawCircle(getWidth() / 2, greyCircleWidth, greyCircleWidth / 2, paintHintPoint);

        // draw 2 point
        paintHintPoint.setColor(colorsGradient[1]);
        canvas.drawCircle(getWidth() / 2, getHeight() - greyCircleWidth, greyCircleWidth / 2, paintHintPointStroke);
        canvas.drawCircle(getWidth() / 2, getHeight() - greyCircleWidth, greyCircleWidth / 2, paintHintPoint);
    }

    private float calculateDegreesForArc() {
        float degrees = (360f / maxValue * currentValue);
        return degrees;
    }
}
