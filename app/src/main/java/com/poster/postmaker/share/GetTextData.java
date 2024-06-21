package com.poster.postmaker.share;

import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.poster.postmaker.R;
import com.poster.postmaker.activity.CreateLogo;

import androidx.core.view.ViewCompat;

public class GetTextData {

    public static void loadTextDialog(final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.add_text_layout);
        dialog.setTitle(null);
        final EditText editText = (EditText) dialog.findViewById(R.id.input_text);
        ((Button) dialog.findViewById(R.id.add)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (editText.getText().toString().length() > 0) {
                    MyTextSticker myTextSticker = new MyTextSticker(context);
                    myTextSticker.setText(editText.getText().toString());
                    myTextSticker.setMaxTextSize(40.0f);
                    myTextSticker.resizeText();
                    myTextSticker.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    CreateLogo.stickerView.addSticker(myTextSticker);
                    CreateLogo.stickerView.invalidate();
                    dialog.dismiss();
                }
            }
        });
        ((Button) dialog.findViewById(R.id.cancl)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public static void loadTextColors(final Context context, LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        final int[] intArray = context.getResources().getIntArray(R.array.allcolors);
        for (int i = 0; i < intArray.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LayoutParams(40, 40));
            imageView.setBackgroundColor(intArray[i]);
            final int finalI = i;
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    try {
                        ((MyTextSticker) CreateLogo.stickerView.getCurrentSticker()).setShader(null);
                        ((MyTextSticker) CreateLogo.stickerView.getCurrentSticker()).setTextColor(intArray[finalI]);
                        CreateLogo.stickerView.invalidate();
                    } catch (Exception unused) {
                        Toast.makeText(context, "Cant Aplly on Image", 1).show();
                    }
                }
            });
            linearLayout.addView(imageView);
        }
    }

    public static void loadGradients(final Context context, LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        for (int i = 0; i < StaticValues.gradientitems.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LayoutParams(40, 40));
            Glide.with(context).load(Integer.valueOf(StaticValues.gradientitems[i])).into(imageView);
            final int finalI = i;
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    try {
                        ((MyTextSticker) CreateLogo.stickerView.getCurrentSticker()).setShader(new BitmapShader(BitmapFactory.decodeResource(context.getResources(), StaticValues.gradientitems[finalI]), TileMode.REPEAT, TileMode.REPEAT));
                        CreateLogo.stickerView.invalidate();
                    } catch (Exception unused) {
                        Toast.makeText(context, "Cant Aplly on Image", 1).show();
                    }
                }
            });
            linearLayout.addView(imageView);
        }
    }

    public static void loadTextures(final Context context, LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        for (int i = 0; i < StaticValues.textures.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LayoutParams(40, 40));
            Glide.with(context).load(Integer.valueOf(StaticValues.textures[i])).into(imageView);
            final int finalI = i;
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    try {
                        ((MyTextSticker) CreateLogo.stickerView.getCurrentSticker()).setShader(new BitmapShader(BitmapFactory.decodeResource(context.getResources(), StaticValues.textures[finalI]), TileMode.REPEAT, TileMode.REPEAT));
                        CreateLogo.stickerView.invalidate();
                    } catch (Exception unused) {
                        Toast.makeText(context, "Cant Aplly on Image", 1).show();
                    }
                }
            });
            linearLayout.addView(imageView);
        }
    }

    public static void loadFontText2d(final Context context, LinearLayout linearLayout) {

        linearLayout.removeAllViews();
        for (int i = 0; i < StaticValues.fonts.length; i++) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new LayoutParams(-2, -2));
            textView.setText("sample");
            textView.setTextColor(-1);
            textView.setPadding(5, 0, 0, 5);
            AssetManager assets = context.getAssets();
            StringBuilder sb = new StringBuilder();
            sb.append("fonts2d/");
            sb.append(StaticValues.fonts[i]);
            textView.setTypeface(Typeface.createFromAsset(assets, sb.toString()));
            textView.setTextSize(25.0f);
            final int finalI = i;
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    try {
                        AssetManager assets = context.getAssets();
                        StringBuilder sb = new StringBuilder();
                        sb.append("fonts2d/");
                        sb.append(StaticValues.fonts[finalI]);
                        ((MyTextSticker) CreateLogo.stickerView.getCurrentSticker()).setTypeface(Typeface.createFromAsset(assets, sb.toString()));
                        CreateLogo.stickerView.invalidate();
                    } catch (Exception unused) {
                        Toast.makeText(context, "Cant Aplly on Image", 1).show();
                    }
                }
            });
            linearLayout.addView(textView);
        }
    }

    public static void loadTextFonts3D(final Context context, LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        for (int i = 0; i < StaticValues.fonts3d.length; i++) {

            TextView textView = new TextView(context);
            textView.setLayoutParams(new LayoutParams(-2, -2));
            textView.setText("Company");
            textView.setTextColor(-1);
            textView.setPadding(5, 0, 0, 5);
            AssetManager assets = context.getAssets();
            StringBuilder sb = new StringBuilder();
            sb.append("fonts3d/");
            sb.append(StaticValues.fonts3d[i]);
            textView.setTypeface(Typeface.createFromAsset(assets, sb.toString()));
            textView.setTextSize(25.0f);
            final int finalI = i;
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    try {
                        AssetManager assets = context.getAssets();
                        StringBuilder sb = new StringBuilder();
                        sb.append("fonts3d/");
                        sb.append(StaticValues.fonts3d[finalI]);
                        ((MyTextSticker) CreateLogo.stickerView.getCurrentSticker()).setTypeface(Typeface.createFromAsset(assets, sb.toString()));
                        CreateLogo.stickerView.invalidate();
                    } catch (Exception unused) {
                        Toast.makeText(context, "Cant Aplly on Image", 1).show();
                    }
                }
            });
            linearLayout.addView(textView);
        }
    }
}
