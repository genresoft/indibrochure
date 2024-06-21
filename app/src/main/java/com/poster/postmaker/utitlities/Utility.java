package com.poster.postmaker.utitlities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Utility {

    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;

    @TargetApi(16)
    public static boolean checkPermissionContects(final Context context, final String str) {
        if (VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, str) == 0) {
            return true;
        }
        Activity activity = (Activity) context;
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
            Builder builder = new Builder(context);
            builder.setCancelable(true);
            builder.setTitle("Permission necessary");
            builder.setMessage("External storage permission is necessary");
            builder.setPositiveButton(17039379, new OnClickListener() {
                @TargetApi(16)
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{str}, Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                }
            });
            builder.create().show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{str}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
        }
        return false;
    }
}
