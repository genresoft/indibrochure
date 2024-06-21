package com.poster.postmaker.workspace;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.bumptech.glide.Glide;
import java.io.File;

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private File[] fileItems;
    private int[] items;

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public GridViewAdapter(Context context2, int[] iArr) {
        this.context = context2;
        this.items = iArr;
    }

    public GridViewAdapter(Context context2, File[] fileArr) {
        this.context = context2;
        this.fileItems = fileArr;
    }

    public int getCount() {
        int[] iArr = this.items;
        if (iArr == null) {
            return this.fileItems.length;
        }
        return iArr.length;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.context);
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        imageView.setLayoutParams(new LayoutParams(100, 100));
        relativeLayout.addView(imageView);
        if (this.items == null) {
            Glide.with(this.context).load(this.fileItems[i]).into(imageView);
        } else {
            Glide.with(this.context).load(Integer.valueOf(this.items[i])).into(imageView);
        }
        return relativeLayout;
    }
}
