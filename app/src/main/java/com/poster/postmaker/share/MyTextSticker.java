package com.poster.postmaker.share;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;

import com.poster.postmaker.R;
import com.xiaopo.flying.sticker.Sticker;

import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class MyTextSticker extends Sticker {

    private static final String mEllipsis = "…";
    private Alignment alignment;
    private final Context context;
    private Drawable drawable;
    private float lineSpacingExtra;
    private float lineSpacingMultiplier;
    private float maxTextSizePixels;
    private float minTextSizePixels;
    private final Rect realBounds;
    private StaticLayout staticLayout;
    private String text;
    private final TextPaint textPaint;
    private final Rect textRect;

    public MyTextSticker(@NonNull Context context2) {
        this(context2, null);
    }

    public MyTextSticker(@NonNull Context context2, @Nullable Drawable drawable2) {

        this.lineSpacingMultiplier = 1.0f;
        this.lineSpacingExtra = 0.0f;
        this.context = context2;
        this.drawable = drawable2;
        if (drawable2 == null) {
            this.drawable = ContextCompat.getDrawable(context2, R.drawable.sticker_transparent_background);
        }
        this.textPaint = new TextPaint(1);
        this.realBounds = new Rect(0, 0, getWidth(), getHeight());
        this.textRect = new Rect(0, 0, getWidth(), getHeight());
        this.minTextSizePixels = convertSpToPx(6.0f);
        this.maxTextSizePixels = convertSpToPx(32.0f);
        this.alignment = Alignment.ALIGN_CENTER;
        this.textPaint.setTextSize(this.maxTextSizePixels);

    }

    public void draw(@NonNull Canvas canvas) {

        Matrix matrix = getMatrix();
        canvas.save();
        canvas.concat(matrix);
        Drawable drawable2 = this.drawable;
        if (drawable2 != null) {
            drawable2.setBounds(this.realBounds);
            this.drawable.draw(canvas);
        }
        canvas.restore();
        canvas.save();
        canvas.concat(matrix);
        if (this.textRect.width() == getWidth()) {
            canvas.translate(0.0f, (float) ((getHeight() / 2) - (this.staticLayout.getHeight() / 2)));
        } else {
            canvas.translate((float) this.textRect.left, (float) ((this.textRect.top + (this.textRect.height() / 2)) - (this.staticLayout.getHeight() / 2)));
        }
        this.staticLayout.draw(canvas);
        canvas.restore();
    }

    public int getWidth() {
        return this.drawable.getIntrinsicWidth();
    }

    public int getHeight() {
        return this.drawable.getIntrinsicHeight();
    }

    public void release() {
        super.release();
        if (this.drawable != null) {
            this.drawable = null;
        }
    }

    @NonNull
    public MyTextSticker setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.textPaint.setAlpha(i);
        return this;
    }

    @NonNull
    public Drawable getDrawable() {
        return this.drawable;
    }

    public MyTextSticker setDrawable(@NonNull Drawable drawable2) {
        this.drawable = drawable2;
        this.realBounds.set(0, 0, getWidth(), getHeight());
        this.textRect.set(0, 0, getWidth(), getHeight());
        return this;
    }

    @NonNull
    public MyTextSticker setDrawable(@NonNull Drawable drawable2, @Nullable Rect rect) {
        this.drawable = drawable2;
        this.realBounds.set(0, 0, getWidth(), getHeight());
        if (rect == null) {
            this.textRect.set(0, 0, getWidth(), getHeight());
        } else {
            this.textRect.set(rect.left, rect.top, rect.right, rect.bottom);
        }
        return this;
    }

    @NonNull
    public MyTextSticker setTypeface(@Nullable Typeface typeface) {
        this.textPaint.setTypeface(typeface);
        return this;
    }

    @NonNull
    public MyTextSticker setTBGColor(@Nullable int i) {
        TextPaint textPaint2 = this.textPaint;
        textPaint2.bgColor = i;
        textPaint2.setStyle(Style.FILL_AND_STROKE);
        this.textPaint.setStrokeWidth(5.0f);
        return this;
    }

    @NonNull
    public MyTextSticker setShader(@Nullable Shader shader) {
        this.textPaint.setShader(shader);
        return this;
    }

    @NonNull
    public MyTextSticker setLayerType(@Nullable float f, float f2, float f3, int i) {
        this.textPaint.setShadowLayer(f, f2, f3, i);
        return this;
    }

    @NonNull
    public MyTextSticker setTextColor(@ColorInt int i) {
        this.textPaint.setColor(i);
        return this;
    }

    @NonNull
    public MyTextSticker setTextAlign(@NonNull Alignment alignment2) {
        this.alignment = alignment2;
        return this;
    }

    @NonNull
    public MyTextSticker setMaxTextSize(@Dimension(unit = 2) float f) {
        this.textPaint.setTextSize(convertSpToPx(f));
        this.maxTextSizePixels = this.textPaint.getTextSize();
        return this;
    }

    @NonNull
    public MyTextSticker setMinTextSize(float f) {
        this.minTextSizePixels = convertSpToPx(f);
        return this;
    }

    @NonNull
    public MyTextSticker setLineSpacing(float f, float f2) {
        this.lineSpacingMultiplier = f2;
        this.lineSpacingExtra = f;
        return this;
    }

    @NonNull
    public MyTextSticker setText(@Nullable String str) {
        this.text = str;
        return this;
    }

    @Nullable
    public String getText() {
        return this.text;
    }

    @NonNull
    public MyTextSticker resizeText() {

        int height = this.textRect.height();
        int width = this.textRect.width();
        String text2 = getText();

        if (text2 != null && text2.length() > 0 && height > 0 && width > 0) {
            float f = this.maxTextSizePixels;

            if (f > 0.0f) {
                int textHeightPixels = getTextHeightPixels(text2, width, f);
                float f2 = f;
                while (textHeightPixels > height) {
                    float f3 = this.minTextSizePixels;
                    if (f2 <= f3) {
                        break;
                    }
                    f2 = Math.max(f2 - 2.0f, f3);
                    textHeightPixels = getTextHeightPixels(text2, width, f2);
                }
                if (f2 == this.minTextSizePixels && textHeightPixels > height) {
                    TextPaint textPaint2 = new TextPaint(this.textPaint);
                    textPaint2.setTextSize(f2);
                    StaticLayout staticLayout2 = new StaticLayout(text2, textPaint2, width, Alignment.ALIGN_NORMAL, this.lineSpacingMultiplier, this.lineSpacingExtra, false);
                    if (staticLayout2.getLineCount() > 0) {
                        int lineForVertical = staticLayout2.getLineForVertical(height) - 1;
                        if (lineForVertical >= 0) {
                            int lineStart = staticLayout2.getLineStart(lineForVertical);
                            int lineEnd = staticLayout2.getLineEnd(lineForVertical);
                            float lineWidth = staticLayout2.getLineWidth(lineForVertical);
                            String str = mEllipsis;
                            float measureText = textPaint2.measureText(str);
                            while (((float) width) < lineWidth + measureText) {
                                lineEnd--;
                                lineWidth = textPaint2.measureText(text2.subSequence(lineStart, lineEnd + 1).toString());
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(text2.subSequence(0, lineEnd));
                            sb.append(str);
                            setText(sb.toString());
                        }
                    }
                }
                this.textPaint.setTextSize(f2);
                StaticLayout staticLayout3 = new StaticLayout(this.text, this.textPaint, this.textRect.width(), this.alignment, this.lineSpacingMultiplier, this.lineSpacingExtra, true);
                this.staticLayout = staticLayout3;
            }
        }
        return this;
    }

    public float getMinTextSizePixels() {
        return this.minTextSizePixels;
    }


    public int getTextHeightPixels(@NonNull CharSequence charSequence, int i, float f) {

        this.textPaint.setTextSize(f);
        StaticLayout staticLayout2 = new StaticLayout(charSequence, this.textPaint, i, Alignment.ALIGN_NORMAL, this.lineSpacingMultiplier, this.lineSpacingExtra, true);
        return staticLayout2.getHeight();

    }

    private float convertSpToPx(float f) {

        return f * this.context.getResources().getDisplayMetrics().scaledDensity;

    }
}
