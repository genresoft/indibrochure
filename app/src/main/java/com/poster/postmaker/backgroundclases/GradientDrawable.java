package com.poster.postmaker.backgroundclases;


import com.poster.postmaker.activity.CreateLogo;

public class GradientDrawable {

    public void manageShape(int i, int i2, int i3, int i4, int i5, int i6) {

        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(i4, i2, (float) i3, (float) i6);
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius((float) i5);
        CreateLogo.stickerView.setBackground(gradientDrawable);
        CreateLogo.stickerView.invalidate();

    }
}
