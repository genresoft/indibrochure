package com.poster.postmaker.share;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextView extends TextView {


    public CustomTextView(Context context) {
        super(context);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "Poor Richard Regular.ttf");
        this.setTypeface(face);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "Poor Richard Regular.ttf");
        this.setTypeface(face);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "Poor Richard Regular.ttf");
        this.setTypeface(face);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}