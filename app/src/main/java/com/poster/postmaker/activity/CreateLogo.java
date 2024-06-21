package com.poster.postmaker.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.poster.postmaker.R;
import com.poster.postmaker.backgroundclases.GetColors;
import com.poster.postmaker.backgroundclases.GradientDrawable;
import com.poster.postmaker.backgroundclases.VisibilityHandler;
import com.poster.postmaker.logosloading.ItemsCons;
import com.poster.postmaker.logosloading.ScheduleAdapter;
import com.poster.postmaker.share.GetTextData;
import com.poster.postmaker.share.MyTextSticker;
import com.poster.postmaker.share.StaticValues;
import com.poster.postmaker.utitlities.Save;
import com.xiaopo.flying.sticker.DrawableSticker;
import com.xiaopo.flying.sticker.StickerView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CreateLogo extends AppCompatActivity implements OnClickListener, OnSeekBarChangeListener {

    public static RelativeLayout backgroundColorsLayout;
    public static RelativeLayout bgMenuitemloading;
    public static RelativeLayout logomenuitemlayout;
    public static RecyclerView logorecylerview;
    public static ImageView stickerBG;
    public static StickerView stickerView;
    public static RelativeLayout textMenuLayout;
    ImageView add_new_Text;
    LinearLayout bgBorderColorItemLayout;
    RelativeLayout bgBorderColorLayout;
    RelativeLayout bgGradientLayout;
    LinearLayout bgImagesItemLayout;
    RelativeLayout bgImagesLayout;
    ImageView bg_color_picker;
    LinearLayout bggradientItemsLayout;
    ImageView borderColorPicker;
    RelativeLayout borderSizeLayout;
    SeekBar bordersizebar;
    LinearLayout colorsBGitemsLayout;
    ImageView gradientPickerBg;
    ArrayList<ItemsCons> items = new ArrayList<>();
    LinearLayout loadBackgrounds;
    LinearLayout loadBorderColor;
    LinearLayout loadBorderGaps;
    LinearLayout loadBorderSize;
    LinearLayout loadBorderStroke;
    LinearLayout loadCirculation;
    LinearLayout loadColors;
    LinearLayout loadGradients;
    LinearLayout loadImages;
    LinearLayout loadLogos;
    LinearLayout loadShapes;
    LinearLayout loadText;
    LinearLayout logocolorLayout;
    LinearLayout opacity;
    LinearLayout saveItem;
    LinearLayout shadowDown;
    LinearLayout shadowUp;
    ArrayList<ItemsCons> shapes = new ArrayList<>();
    LinearLayout shareItem;
    LinearLayout textColor;
    LinearLayout textGradient;
    LinearLayout textItemloading;
    SeekBar textSeek;
    LinearLayout textfonts2d;
    LinearLayout textfonts3d;
    LinearLayout texttextures;
    ImageView upload_bg;
    ImageView upload_logo;

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.create_logo);

        setRequestedOrientation(1);
        getWindow().setSoftInputMode(48);

        stickerView = (StickerView) findViewById(R.id.sticker_view);
        stickerBG = (ImageView) findViewById(R.id.stickerback);
        stickerView.setOnClickListener(this);
        stickerBG.setOnClickListener(this);
        this.loadBackgrounds = (LinearLayout) findViewById(R.id.loadbackgrounds);
        this.loadBackgrounds.setOnClickListener(this);
        this.loadLogos = (LinearLayout) findViewById(R.id.loadlogos);
        this.loadLogos.setOnClickListener(this);
        this.loadShapes = (LinearLayout) findViewById(R.id.loadshapes);
        this.loadShapes.setOnClickListener(this);
        this.loadText = (LinearLayout) findViewById(R.id.loadtext);
        this.loadText.setOnClickListener(this);
        bgMenuitemloading = (RelativeLayout) findViewById(R.id.menuloadinglayout);
        logomenuitemlayout = (RelativeLayout) findViewById(R.id.logomenuloadinglayout);
        textMenuLayout = (RelativeLayout) findViewById(R.id.textmenuloadinglayout);
        this.loadColors = (LinearLayout) findViewById(R.id.loadcolors);
        this.loadColors.setOnClickListener(this);
        this.loadGradients = (LinearLayout) findViewById(R.id.loadgradients);
        this.loadGradients.setOnClickListener(this);
        this.loadImages = (LinearLayout) findViewById(R.id.loadimages);
        this.loadImages.setOnClickListener(this);
        this.loadBorderColor = (LinearLayout) findViewById(R.id.loadborderclor);
        this.loadBorderColor.setOnClickListener(this);
        this.loadBorderSize = (LinearLayout) findViewById(R.id.loadbordersize);
        this.loadBorderSize.setOnClickListener(this);
        this.loadBorderStroke = (LinearLayout) findViewById(R.id.loadborderstroke);
        this.loadBorderStroke.setOnClickListener(this);
        this.loadBorderGaps = (LinearLayout) findViewById(R.id.loadbordergaps);
        this.loadBorderGaps.setOnClickListener(this);
        this.loadCirculation = (LinearLayout) findViewById(R.id.loadroundbg);
        this.loadCirculation.setOnClickListener(this);
        this.upload_bg = (ImageView) findViewById(R.id.upload_new);
        this.upload_bg.setOnClickListener(this);
        this.upload_logo = (ImageView) findViewById(R.id.upload_new_logo);
        this.upload_logo.setOnClickListener(this);
        backgroundColorsLayout = (RelativeLayout) findViewById(R.id.backgroundcolorslayout);
        this.bg_color_picker = (ImageView) findViewById(R.id.bg_color_picker);
        this.bg_color_picker.setOnClickListener(this);
        this.colorsBGitemsLayout = (LinearLayout) findViewById(R.id.color_background_items_layout);
        this.bgGradientLayout = (RelativeLayout) findViewById(R.id.backgroundgradientlayout);
        this.bggradientItemsLayout = (LinearLayout) findViewById(R.id.gradient_background_items_layout);
        this.gradientPickerBg = (ImageView) findViewById(R.id.bg_gradient_picker);
        this.gradientPickerBg.setOnClickListener(this);
        this.bgImagesLayout = (RelativeLayout) findViewById(R.id.backgroundimageslayout);
        this.bgImagesItemLayout = (LinearLayout) findViewById(R.id.image_background_items_layout);
        this.bgBorderColorLayout = (RelativeLayout) findViewById(R.id.backgroundbordercolorlayout);
        this.bgBorderColorItemLayout = (LinearLayout) findViewById(R.id.color_background_border_items_layout);
        this.borderColorPicker = (ImageView) findViewById(R.id.border_color_picker);
        this.borderColorPicker.setOnClickListener(this);
        this.borderSizeLayout = (RelativeLayout) findViewById(R.id.backgroundbordersizelayout);
        this.bordersizebar = (SeekBar) findViewById(R.id.borderSizeseekbar);
        this.bordersizebar.setOnSeekBarChangeListener(this);
        this.logocolorLayout = (LinearLayout) findViewById(R.id.logocolorlayout);
        logorecylerview = (RecyclerView) findViewById(R.id.recylerView);
        logorecylerview.setLayoutManager(new GridLayoutManager(this, 5));
        convet();
        this.add_new_Text = (ImageView) findViewById(R.id.add_new_text);
        this.add_new_Text.setOnClickListener(this);
        this.textItemloading = (LinearLayout) findViewById(R.id.items_text_loading);
        this.textColor = (LinearLayout) findViewById(R.id.loadtextcolors);
        this.textColor.setOnClickListener(this);
        this.textGradient = (LinearLayout) findViewById(R.id.loadtextgradients);
        this.textGradient.setOnClickListener(this);
        this.texttextures = (LinearLayout) findViewById(R.id.loadtexttextures);
        this.texttextures.setOnClickListener(this);
        this.textfonts2d = (LinearLayout) findViewById(R.id.loadtextfont2d);
        this.textfonts2d.setOnClickListener(this);
        this.textfonts3d = (LinearLayout) findViewById(R.id.loadtextfont3d);
        this.textfonts3d.setOnClickListener(this);
        this.shadowDown = (LinearLayout) findViewById(R.id.textshadowdown);
        this.shadowDown.setOnClickListener(this);
        this.shadowUp = (LinearLayout) findViewById(R.id.textshadowup);
        this.shadowUp.setOnClickListener(this);
        this.opacity = (LinearLayout) findViewById(R.id.textopacity);
        this.opacity.setOnClickListener(this);
        this.textSeek = (SeekBar) findViewById(R.id.textSeek);
        this.textSeek.setOnSeekBarChangeListener(this);
        this.saveItem = (LinearLayout) findViewById(R.id.save);
        this.shareItem = (LinearLayout) findViewById(R.id.share);
        this.saveItem.setOnClickListener(this);
        this.shareItem.setOnClickListener(this);

    }

    private void convet() {
        for (int itemsCons : StaticValues.logos) {
            this.items.add(new ItemsCons(itemsCons));
        }
        for (int itemsCons2 : StaticValues.shapes) {
            this.shapes.add(new ItemsCons(itemsCons2));
        }
    }

    public void onClick(View view) {
        if (view.equals(stickerBG)) {
            if (stickerView.isLocked()) {
                stickerView.setLocked(false);
            } else {
                stickerView.setLocked(true);
            }
        } else if (view.equals(stickerView)) {
            if (stickerView.isLocked()) {
                stickerView.setLocked(false);
            } else {
                stickerView.setLocked(true);
            }
        } else if (view.equals(this.loadBackgrounds)) {
            VisibilityHandler.manageMenuVisibility(1, bgMenuitemloading, logomenuitemlayout, textMenuLayout);
        } else if (view.equals(this.loadColors)) {
            VisibilityHandler.visibleLayout(1, backgroundColorsLayout, this.bgGradientLayout, this.bgImagesLayout, this.bgBorderColorLayout, this.borderSizeLayout);
            VisibilityHandler.removeItems(1, this.colorsBGitemsLayout, this.bggradientItemsLayout, this.bgImagesItemLayout, this.bgBorderColorItemLayout);
            GetColors.loadColors(this.colorsBGitemsLayout, this);
        } else if (view.equals(this.bg_color_picker)) {
            GetColors.returnBackgroundColor(StaticValues.bgColor, this);
            stickerBG.setColorFilter(StaticValues.bgColor);
        } else if (view.equals(this.loadGradients)) {
            VisibilityHandler.visibleLayout(2, backgroundColorsLayout, this.bgGradientLayout, this.bgImagesLayout, this.bgBorderColorLayout, this.borderSizeLayout);
            VisibilityHandler.removeItems(2, this.colorsBGitemsLayout, this.bggradientItemsLayout, this.bgImagesItemLayout, this.bgBorderColorItemLayout);
            GetColors.loadGradients(this.bggradientItemsLayout, this);
        } else if (view.equals(this.gradientPickerBg)) {
            GetColors.loadGradientPicker(this);
        } else if (view.equals(this.loadImages)) {
            VisibilityHandler.visibleLayout(3, backgroundColorsLayout, this.bgGradientLayout, this.bgImagesLayout, this.bgBorderColorLayout, this.borderSizeLayout);
            VisibilityHandler.removeItems(3, this.colorsBGitemsLayout, this.bggradientItemsLayout, this.bgImagesItemLayout, this.bgBorderColorItemLayout);
            GetColors.loadImages(this.bgImagesItemLayout, this);
        } else if (view.equals(this.loadBorderColor)) {
            VisibilityHandler.visibleLayout(4, backgroundColorsLayout, this.bgGradientLayout, this.bgImagesLayout, this.bgBorderColorLayout, this.borderSizeLayout);
            VisibilityHandler.removeItems(4, this.colorsBGitemsLayout, this.bggradientItemsLayout, this.bgImagesItemLayout, this.bgBorderColorItemLayout);
            GetColors.loadBGBorderColor(this.bgBorderColorItemLayout, this);
        } else if (view.equals(this.borderColorPicker)) {
            GetColors.loadBorderColorDialog(this);
        } else if (view.equals(this.loadBorderSize)) {
            VisibilityHandler.visibleLayout(5, backgroundColorsLayout, this.bgGradientLayout, this.bgImagesLayout, this.bgBorderColorLayout, this.borderSizeLayout);
            StaticValues.borderItemseekChoser = 1;
            this.bordersizebar.setMax(25);
        } else if (view.equals(this.loadBorderGaps)) {
            VisibilityHandler.visibleLayout(5, backgroundColorsLayout, this.bgGradientLayout, this.bgImagesLayout, this.bgBorderColorLayout, this.borderSizeLayout);
            StaticValues.borderItemseekChoser = 2;
            this.bordersizebar.setMax(25);
        } else if (view.equals(this.loadBorderStroke)) {
            VisibilityHandler.visibleLayout(5, backgroundColorsLayout, this.bgGradientLayout, this.bgImagesLayout, this.bgBorderColorLayout, this.borderSizeLayout);
            StaticValues.borderItemseekChoser = 3;
            this.bordersizebar.setMax(25);
        } else if (view.equals(this.loadCirculation)) {
            VisibilityHandler.visibleLayout(5, backgroundColorsLayout, this.bgGradientLayout, this.bgImagesLayout, this.bgBorderColorLayout, this.borderSizeLayout);
            StaticValues.borderItemseekChoser = 4;
            this.bordersizebar.setMax(500);
        } else if (view.equals(this.upload_bg)) {
            startPhotoPickIntent(100);
        } else if (view.equals(this.upload_logo)) {
            openGallery();
        } else if (view.equals(this.loadLogos)) {
            VisibilityHandler.manageMenuVisibility(2, bgMenuitemloading, logomenuitemlayout, textMenuLayout);
            StaticValues.f79i = 1;
            logorecylerview.setVisibility(0);
            loadLogo(this.items);
        } else if (view.equals(this.loadShapes)) {
            VisibilityHandler.manageMenuVisibility(3, bgMenuitemloading, logomenuitemlayout, textMenuLayout);
            StaticValues.f79i = 2;
            logorecylerview.setVisibility(0);
            loadLogo(this.shapes);
        } else if (view.equals(this.loadText)) {
            VisibilityHandler.manageMenuVisibility(4, bgMenuitemloading, logomenuitemlayout, textMenuLayout);
        } else if (view.equals(this.add_new_Text)) {
            GetTextData.loadTextDialog(this);
        } else if (view.equals(this.textColor)) {
            GetTextData.loadTextColors(this, this.textItemloading);
        } else if (view.equals(this.textGradient)) {
            GetTextData.loadGradients(this, this.textItemloading);
        } else if (view.equals(this.texttextures)) {
            GetTextData.loadTextures(this, this.textItemloading);
        } else if (view.equals(this.textfonts2d)) {
            GetTextData.loadFontText2d(this, this.textItemloading);
        } else if (view.equals(this.textfonts3d)) {
            GetTextData.loadTextFonts3D(this, this.textItemloading);
        } else if (view.equals(this.shadowDown)) {
            this.textSeek.setMax(20);
            this.textSeek.setProgress(0);
            StaticValues.f80ts = 1;
        } else if (view.equals(this.shadowUp)) {
            this.textSeek.setMax(20);
            this.textSeek.setProgress(0);
            StaticValues.f80ts = 2;
        } else if (view.equals(this.opacity)) {
            this.textSeek.setMax(255);
            this.textSeek.setProgress(255);
            StaticValues.f80ts = 3;
        } else if (view.equals(this.saveItem)) {


            stickerView.setControlItemsHidden();
            //CreateLogo.stickerBG.setColorFilter(null);
            //CreateLogo.stickerBG.setImageResource(0);
            //CreateLogo.stickerBG.setImageBitmap(null);

            try {
                stickerView.setControlItemsHidden();

                new Save(CreateLogo.stickerView, CreateLogo.this).execute(new Void[0]);
                //CreateLogo.stickerBG.setImageResource(R.drawable.trans);

            } catch (Exception unused) {

            }
            /*try {

                stickerView.setControlItemsHidden();

                new Save(CreateLogo.stickerView,CreateLogo.this).execute(new Void[0]);

            } catch (Exception unused) {
            }



            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.save_dialog);
            dialog.setTitle("Choose?");
            dialog.setCancelable(true);

            ((ImageView) dialog.findViewById(R.id.png)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {

                    stickerView.setControlItemsHidden();

                    stickerView.setBackgroundDrawable(null);
                    CreateLogo.stickerBG.setColorFilter(null);
                    CreateLogo.stickerBG.setImageResource(0);
                    CreateLogo.stickerBG.setImageBitmap(null);

                    try {

                        stickerView.setControlItemsHidden();




                        new Save(CreateLogo.stickerView,CreateLogo.this).execute(new Void[0]);
                        CreateLogo.stickerBG.setImageResource(R.drawable.trans);

                    } catch (Exception unused) {

                    }

                    dialog.dismiss();

                }
            });

            ((ImageView) dialog.findViewById(R.id.jpg)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {


                    stickerView.setControlItemsHidden();
                    CreateLogo.stickerBG.setColorFilter(null);
                    CreateLogo.stickerBG.setImageResource(0);
                    CreateLogo.stickerBG.setImageBitmap(null);

                    try {

                        stickerView.setControlItemsHidden();

                        new Save(CreateLogo.stickerView,CreateLogo.this).execute(new Void[0]);

                    } catch (Exception unused) {
                    }

                    dialog.dismiss();

                }
            });

            dialog.show();*/

        } else if (view.equals(this.shareItem)) {

            if (StaticValues.filetosave == null) {

                try {
                    new Save(stickerView, CreateLogo.this).execute(new Void[0]);
                } catch (Exception unused) {
                    Toast.makeText(this, "Cant't Save yet", 1).show();
                }

            }

            try {

                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(StaticValues.filetosave);
                File file = new File(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("file://");
                sb2.append(file.getAbsolutePath());
                Uri parse = Uri.parse(sb2.toString());
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", parse);
                intent.setType("image/*");
                intent.addFlags(1);
                startActivity(Intent.createChooser(intent, "Share image File"));

            } catch (Exception unused2) {

                Toast.makeText(this, "Cant Share", 1).show();

            }
        }
    }

    public void loadLogo(ArrayList arrayList) {

        GetColors.loadLogoColors(this, this.logocolorLayout);
        logorecylerview.setAdapter(new ScheduleAdapter(arrayList, this));

    }


    public void onActivityResult(int i, int i2, Intent intent) {

        if (i2 == -1 && i == 1001) {
            new ImageView(this);
            new LayoutParams(-2, -2).addRule(13);
            stickerView.addSticker(new DrawableSticker(new BitmapDrawable(getResources(), BitmapFactory.decodeFile(getTempFile().getAbsolutePath()))));
        }
        if (i == 100) {
            stickerBG.setImageBitmap(BitmapFactory.decodeFile(getTempFile().getAbsolutePath()));
        }
        super.onActivityResult(i, i2, intent);

    }

    private Uri getTempUri() {
        return Uri.fromFile(getTempFile());
    }

    private void openGallery() {
        Intent intent = new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("output", getTempFileUri());
        intent.putExtra("outputFormat", CompressFormat.JPEG.toString());
        startActivityForResult(intent, 1001);
    }

    private Uri getTempFileUri() {

        return Uri.fromFile(getTempFile());

    }

    private File getTempFile() {

        File file = new File(Environment.getExternalStorageDirectory(), "temp_file.jpeg");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;

    }

    private void startPhotoPickIntent(int i) {

        Intent intent = new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("output", getTempUri());
        intent.putExtra("outputFormat", CompressFormat.PNG.toString());
        startActivityForResult(intent, i);

    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {

        if (seekBar.equals(this.bordersizebar)) {

            if (StaticValues.borderItemseekChoser == 1) {
                StaticValues.border_size = i;
                new GradientDrawable().manageShape(0, StaticValues.border_color, StaticValues.border_size, StaticValues.border_space, StaticValues.border_radious, StaticValues.border_stroke);
            } else if (StaticValues.borderItemseekChoser == 2) {
                StaticValues.border_space = i;
                new GradientDrawable().manageShape(0, StaticValues.border_color, StaticValues.border_size, StaticValues.border_space, StaticValues.border_radious, StaticValues.border_stroke);
            } else if (StaticValues.borderItemseekChoser == 3) {
                StaticValues.border_stroke = i;
                new GradientDrawable().manageShape(0, StaticValues.border_color, StaticValues.border_size, StaticValues.border_space, StaticValues.border_radious, StaticValues.border_stroke);
            } else if (StaticValues.borderItemseekChoser == 4) {
                StaticValues.border_radious = i;
                StaticValues.image_radious = (i * 2) - 5;
                new GradientDrawable().manageShape(0, StaticValues.border_color, StaticValues.border_size, StaticValues.border_space, StaticValues.border_radious, StaticValues.border_stroke);

                try {
                    GetColors.roundImageView(stickerBG, StaticValues.image_radious);
                } catch (Exception unused) {
                }

            }

        } else if (seekBar == this.textSeek) {

            String str = "Can't Aplly on Image";
            if (StaticValues.f80ts == 1) {
                try {
                    float f = (float) i;
                    float f2 = (float) (-i);
                    ((MyTextSticker) stickerView.getCurrentSticker()).setLayerType(f, f2, f2, ViewCompat.MEASURED_STATE_MASK);
                    stickerView.invalidate();
                } catch (Exception unused2) {
                    Toast.makeText(this, str, 1).show();
                }
            } else if (StaticValues.f80ts == 2) {
                try {
                    float f3 = (float) i;
                    ((MyTextSticker) stickerView.getCurrentSticker()).setLayerType(f3, f3, f3, ViewCompat.MEASURED_STATE_MASK);
                    stickerView.invalidate();
                } catch (Exception unused3) {
                    Toast.makeText(this, str, 1).show();
                }
            } else if (StaticValues.f80ts == 3) {
                stickerView.getCurrentSticker().setAlpha(i);
                stickerView.invalidate();
            }
        }
    }

    public void onBackPressed() {
        adverTisementDialog();
    }

    public void adverTisementDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.create_advertising);
        dialog.setTitle("Selesai?");
        dialog.setCancelable(true);
        ((TextView) dialog.findViewById(R.id.yes)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {

                CreateLogo.this.finish();
                dialog.dismiss();
            }
        });
        ((TextView) dialog.findViewById(R.id.no)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();

            }
        });
        dialog.show();
    }
}
