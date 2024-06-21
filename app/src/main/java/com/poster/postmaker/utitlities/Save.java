package com.poster.postmaker.utitlities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.poster.postmaker.activity.CreateLogo;
import com.poster.postmaker.activity.FullScreenImageActivity;
import com.poster.postmaker.share.Share;
import com.poster.postmaker.share.StaticValues;
import com.xiaopo.flying.sticker.StickerView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save extends AsyncTask<Void, Void, String> {

    Context context;
    private File fileTosave;
    private Bitmap imageToSave;
    private View imageView;
    private ProgressDialog progressDialog;

    public Save(View view,Context context) {

        this.context = context;
        this.imageView = view;
        view.setDrawingCacheEnabled(true);
        this.imageToSave = view.getDrawingCache();

    }

    public Save(StickerView stickerView, CreateLogo createLogo) {

        this.context = createLogo;
        this.imageView = stickerView;
        stickerView.setDrawingCacheEnabled(true);
        this.imageToSave = stickerView.getDrawingCache();

    }

    public void onPreExecute() {

        this.progressDialog = new ProgressDialog(this.imageView.getContext());
        this.progressDialog.requestWindowFeature(1);
        this.progressDialog.setMessage("Saving........");
        this.progressDialog.show();

    }

    public String doInBackground(Void... voidArr) {

        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append(File.separator);
        sb.append(StaticValues.D_NAME);


        File file = new File(Share.IMAGE_PATH);

        if (!file.exists()) {
            file.mkdir();
        }

        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append(".png");
        this.fileTosave = new File(file, sb2.toString());

        Log.e("TAG", "doInBackground:---> " + fileTosave.toString());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.fileTosave);
            this.imageToSave.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            StaticValues.filetosave = this.fileTosave;


            return "Image Saved Successfully";
        } catch (IOException e) {
            return e.getMessage();
        }

    }


    public void onPostExecute(String str) {

        this.progressDialog.dismiss();
        Toast.makeText(this.imageView.getContext(), str, 0).show();
        this.imageView.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.fileTosave)));
        this.imageView.setDrawingCacheEnabled(false);


        Intent intent = new Intent(context, FullScreenImageActivity.class);
        Share.Fragment = "MyPhotosFragment";
        intent.putExtra("avairy", "");
        context.startActivity(intent);

    }
}
