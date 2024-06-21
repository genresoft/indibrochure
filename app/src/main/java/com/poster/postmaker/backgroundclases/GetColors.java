package com.poster.postmaker.backgroundclases;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.bumptech.glide.Glide;
import com.poster.postmaker.R;
import com.github.danielnilsson9.colorpickerview.view.ColorPanelView;
import com.github.danielnilsson9.colorpickerview.view.ColorPickerView;
import com.github.danielnilsson9.colorpickerview.view.ColorPickerView.OnColorChangedListener;
import com.poster.postmaker.activity.CreateLogo;
import com.poster.postmaker.share.StaticValues;
import com.xiaopo.flying.sticker.DrawableSticker;

public class GetColors {

    public static Bitmap mbitmap;
    public static Bitmap myBitmap;

    public static void returnBackgroundColor(int i, Context context) {

        final Dialog dialog = new Dialog(context);
        dialog.setTitle("Chose Color");
        dialog.setContentView(R.layout.color_picker_dialog);
        final ColorPickerView colorPickerView = (ColorPickerView) dialog.findViewById(R.id.colorpickerview__color_picker_view);
        final ColorPanelView colorPanelView = (ColorPanelView) dialog.findViewById(R.id.colorpickerview__color_panel_new);
        ColorPanelView colorPanelView2 = (ColorPanelView) dialog.findViewById(R.id.colorpickerview__color_panel_old);
        colorPickerView.setColor(i);
        colorPanelView.setColor(i);
        colorPanelView2.setColor(i);
        Button button = (Button) dialog.findViewById(R.id.okButton);
        Button button2 = (Button) dialog.findViewById(R.id.cancelButton);
        colorPickerView.setOnColorChangedListener(new OnColorChangedListener() {
            public void onColorChanged(int i) {
                colorPanelView.setColor(colorPickerView.getColor());
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                StaticValues.bgColor = colorPanelView.getColor();
                CreateLogo.stickerBG.setColorFilter(colorPanelView.getColor());
                CreateLogo.stickerView.invalidate();
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    public static void loadColors(LinearLayout linearLayout, Context context) {

        linearLayout.removeAllViews();
        final int[] intArray = context.getResources().getIntArray(R.array.allcolors);
        for (int i = 0; i < intArray.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LayoutParams(50, 50));
            imageView.setPadding(3, 0, 0, 0);
            imageView.setBackgroundColor(intArray[i]);
            final int finalI = i;
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    CreateLogo.stickerBG.setColorFilter(intArray[finalI]);
                    CreateLogo.stickerView.invalidate();
                }
            });
            linearLayout.addView(imageView);
        }

    }

    public static void loadGradients(LinearLayout linearLayout, final Context context) {

        linearLayout.removeAllViews();
        final int[] iArr = {R.drawable.img_bg_1, R.drawable.img_bg_2, R.drawable.img_bg_3, R.drawable.img_bg_4, R.drawable.img_bg_5, R.drawable.img_bg_6, R.drawable.img_bg_7, R.drawable.img_bg_8, R.drawable.img_bg_9, R.drawable.img_bg_10};
        for (int i = 0; i < iArr.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LayoutParams(50, 50));
            Glide.with(context).load(Integer.valueOf(iArr[i])).into(imageView);
            final int finalI = i;
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    CreateLogo.stickerBG.setColorFilter(null);
                    GetColors.mbitmap = GetColors.getResizedBitmap(((BitmapDrawable) context.getResources().getDrawable(iArr[finalI])).getBitmap(), 1191, 842);
                    GetColors.roundImageView(CreateLogo.stickerBG, StaticValues.image_radious);
                }
            });
            linearLayout.addView(imageView);
        }

    }

    public static void roundImageView(ImageView imageView, int i) {

        Bitmap createBitmap = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(mbitmap, TileMode.CLAMP, TileMode.CLAMP));
        float f = (float) i;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) mbitmap.getWidth(), (float) mbitmap.getHeight()), f, f, paint);
        imageView.setImageBitmap(createBitmap);

    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = ((float) i) / ((float) width);
        float f2 = ((float) i2) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    public static void loadGradientPicker(Context context) {
        mbitmap = ((BitmapDrawable) CreateLogo.stickerBG.getDrawable()).getBitmap();
        gradient2(context);
        gradient1(context);
    }

    public static void gradient1(final Context context) {

        final Dialog dialog = new Dialog(context);
        dialog.setTitle("Chose Color 1");
        dialog.setContentView(R.layout.color_picker_dialog);
        final ColorPickerView colorPickerView = (ColorPickerView) dialog.findViewById(R.id.colorpickerview__color_picker_view);
        final ColorPanelView colorPanelView = (ColorPanelView) dialog.findViewById(R.id.colorpickerview__color_panel_new);
        ColorPanelView colorPanelView2 = (ColorPanelView) dialog.findViewById(R.id.colorpickerview__color_panel_old);
        colorPickerView.setColor(StaticValues.gradColor1);
        colorPanelView.setColor(StaticValues.gradColor1);
        colorPanelView2.setColor(StaticValues.gradColor1);
        Button button = (Button) dialog.findViewById(R.id.okButton);
        Button button2 = (Button) dialog.findViewById(R.id.cancelButton);
        colorPickerView.setOnColorChangedListener(new OnColorChangedListener() {
            public void onColorChanged(int i) {
                colorPanelView.setColor(colorPickerView.getColor());
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                StaticValues.gradColor1 = colorPanelView.getColor();
                CreateLogo.stickerBG.setImageDrawable(new BitmapDrawable(context.getResources(), GetColors.addGradient(GetColors.mbitmap, StaticValues.gradColor1, StaticValues.gradColor2)));
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    public static void gradient2(final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setTitle("Chose Color 2");
        dialog.setContentView(R.layout.color_picker_dialog);
        final ColorPickerView colorPickerView = (ColorPickerView) dialog.findViewById(R.id.colorpickerview__color_picker_view);
        final ColorPanelView colorPanelView = (ColorPanelView) dialog.findViewById(R.id.colorpickerview__color_panel_new);
        ColorPanelView colorPanelView2 = (ColorPanelView) dialog.findViewById(R.id.colorpickerview__color_panel_old);
        colorPickerView.setColor(StaticValues.gradColor2);
        colorPanelView.setColor(StaticValues.gradColor2);
        colorPanelView2.setColor(StaticValues.gradColor2);
        Button button = (Button) dialog.findViewById(R.id.okButton);
        Button button2 = (Button) dialog.findViewById(R.id.cancelButton);
        colorPickerView.setOnColorChangedListener(new OnColorChangedListener() {
            public void onColorChanged(int i) {
                colorPanelView.setColor(colorPickerView.getColor());
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                StaticValues.gradColor2 = colorPanelView.getColor();
                CreateLogo.stickerBG.setImageDrawable(new BitmapDrawable(context.getResources(), GetColors.addGradient(GetColors.mbitmap, StaticValues.gradColor1, StaticValues.gradColor2)));
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public static Bitmap addGradient(Bitmap bitmap, int i, int i2) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
        Paint paint = new Paint();
        float f = (float) height;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, f, i, i2, TileMode.CLAMP);
        paint.setShader(linearGradient);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawRect(0.0f, 0.0f, (float) width, f, paint);
        return createBitmap;

    }

    public static void loadImages(LinearLayout linearLayout, final Context context) {

        linearLayout.removeAllViews();

        final int[] iArr = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6, R.drawable.b7, R.drawable.b8, R.drawable.b9, R.drawable.b10, R.drawable.b11, R.drawable.b12, R.drawable.b13, R.drawable.b14, R.drawable.b15, R.drawable.b16, R.drawable.b17, R.drawable.b18, R.drawable.b19, R.drawable.b20, R.drawable.b21, R.drawable.b22, R.drawable.b23, R.drawable.b24, R.drawable.b25, R.drawable.b26, R.drawable.b27, R.drawable.b28, R.drawable.b29, R.drawable.b30, R.drawable.b31, R.drawable.b32, R.drawable.b33, R.drawable.b34, R.drawable.b35, R.drawable.b36, R.drawable.b37, R.drawable.b38, R.drawable.b39, R.drawable.b40, R.drawable.b41, R.drawable.b42, R.drawable.b43, R.drawable.b44, R.drawable.b45, R.drawable.b46, R.drawable.b47, R.drawable.b48, R.drawable.b49, R.drawable.b50, R.drawable.b51, R.drawable.b52, R.drawable.b53, R.drawable.b54, R.drawable.b55, R.drawable.b56, R.drawable.b57, R.drawable.b58, R.drawable.b59, R.drawable.b60, R.drawable.birthday_10, R.drawable.birthday_11, R.drawable.birthday_12, R.drawable.birthday_13, R.drawable.birthday_14, R.drawable.birthday_15, R.drawable.bokeh_0, R.drawable.bokeh_1, R.drawable.bokeh_2, R.drawable.bokeh_3, R.drawable.bokeh_4, R.drawable.brick_0, R.drawable.brick_1, R.drawable.brick_2, R.drawable.brick_3, R.drawable.brick_4, R.drawable.cats_0, R.drawable.cats_1, R.drawable.cats_2, R.drawable.cats_3, R.drawable.cats_4, R.drawable.chevron_0, R.drawable.chevron_1, R.drawable.chevron_2, R.drawable.chevron_3, R.drawable.chevron_4, R.drawable.dogs_0, R.drawable.dogs_1, R.drawable.dogs_2, R.drawable.dogs_3, R.drawable.dogs_4, R.drawable.fall_0, R.drawable.fall_1, R.drawable.fall_2, R.drawable.fall_3, R.drawable.fall_4, R.drawable.flower_0, R.drawable.flower_1, R.drawable.flower_2, R.drawable.flower_3, R.drawable.flower_4, R.drawable.glitter_0, R.drawable.glitter_1, R.drawable.glitter_2, R.drawable.glitter_3, R.drawable.glitter_4, R.drawable.halloween_0, R.drawable.halloween_1, R.drawable.halloween_2, R.drawable.halloween_3, R.drawable.halloween_4, R.drawable.hipster_0, R.drawable.hipster_1, R.drawable.hipster_2, R.drawable.hipster_3, R.drawable.hipster_4, R.drawable.love_0, R.drawable.love_1, R.drawable.love_2, R.drawable.love_3, R.drawable.love_4, R.drawable.retro_0, R.drawable.retro_1, R.drawable.retro_2, R.drawable.retro_3, R.drawable.retro_4, R.drawable.watercolor_0, R.drawable.watercolor_1, R.drawable.watercolor_2, R.drawable.watercolor_3, R.drawable.watercolor_4, R.drawable.wood_8, R.drawable.wood_9, R.drawable.wood_10, R.drawable.wood_11, R.drawable.wood_12};

        for (int i = 0; i < iArr.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LayoutParams(50, 50));
            Glide.with(context).load(Integer.valueOf(iArr[i])).into(imageView);
            final int finalI = i;
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    CreateLogo.stickerBG.setColorFilter(null);
                    GetColors.mbitmap = GetColors.getResizedBitmap(((BitmapDrawable) context.getResources().getDrawable(iArr[finalI])).getBitmap(), 1191, 842);
                    GetColors.roundImageView(CreateLogo.stickerBG, StaticValues.image_radious);
                }
            });
            linearLayout.addView(imageView);
        }
    }

    public static void loadBGBorderColor(LinearLayout linearLayout, Context context) {

        linearLayout.removeAllViews();

        final int[] intArray = context.getResources().getIntArray(R.array.allcolors);

        for (int i = 0; i < intArray.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LayoutParams(50, 50));
            imageView.setPadding(3, 0, 0, 0);
            imageView.setBackgroundColor(intArray[i]);
            final int finalI = i;
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    StaticValues.border_color = intArray[finalI];
                    new GradientDrawable().manageShape(0, StaticValues.border_color, StaticValues.border_size, StaticValues.border_space, StaticValues.border_radious, StaticValues.border_stroke);
                }
            });
            linearLayout.addView(imageView);
        }

    }

    public static void loadBorderColorDialog(Context context) {

        final Dialog dialog = new Dialog(context);
        dialog.setTitle("Chose Color");
        dialog.setContentView(R.layout.color_picker_dialog);
        final ColorPickerView colorPickerView = (ColorPickerView) dialog.findViewById(R.id.colorpickerview__color_picker_view);
        final ColorPanelView colorPanelView = (ColorPanelView) dialog.findViewById(R.id.colorpickerview__color_panel_new);
        ColorPanelView colorPanelView2 = (ColorPanelView) dialog.findViewById(R.id.colorpickerview__color_panel_old);
        colorPickerView.setColor(StaticValues.border_color);
        colorPanelView.setColor(StaticValues.border_color);
        colorPanelView2.setColor(StaticValues.border_color);
        Button button = (Button) dialog.findViewById(R.id.okButton);
        Button button2 = (Button) dialog.findViewById(R.id.cancelButton);
        colorPickerView.setOnColorChangedListener(new OnColorChangedListener() {
            public void onColorChanged(int i) {
                colorPanelView.setColor(colorPickerView.getColor());
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                StaticValues.border_color = colorPanelView.getColor();
                new GradientDrawable().manageShape(0, StaticValues.border_color, StaticValues.border_size, StaticValues.border_space, StaticValues.border_radious, StaticValues.border_stroke);
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    public static void loadLogoColors(Context context, LinearLayout linearLayout) {

        linearLayout.removeAllViews();

        final int[] intArray = context.getResources().getIntArray(R.array.allcolors);

        for (int i = 0; i < intArray.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LayoutParams(50, 50));
            imageView.setPadding(3, 0, 0, 0);
            imageView.setBackgroundColor(intArray[i]);
            final int finalI = i;
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (CreateLogo.stickerView.getCurrentSticker() instanceof DrawableSticker) {
                        int[] iArr = intArray;
                        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, (float) ((iArr[finalI] & 16711680) / SupportMenu.USER_MASK), 0.0f, 0.0f, 0.0f, 0.0f, (float) ((iArr[finalI] & MotionEventCompat.ACTION_POINTER_INDEX_MASK) / 255), 0.0f, 0.0f, 0.0f, 0.0f, (float) (iArr[finalI] & 255), 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                        Drawable drawable = ((DrawableSticker) CreateLogo.stickerView.getCurrentSticker()).getDrawable();
                        drawable.setColorFilter(colorMatrixColorFilter);
                        ((DrawableSticker) CreateLogo.stickerView.getCurrentSticker()).setDrawable(drawable);
                        CreateLogo.stickerView.replace((DrawableSticker) CreateLogo.stickerView.getCurrentSticker());
                        CreateLogo.stickerView.invalidate();
                    }
                }
            });
            linearLayout.addView(imageView);
        }
    }
}
