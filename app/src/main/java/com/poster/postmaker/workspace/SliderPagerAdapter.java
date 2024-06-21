package com.poster.postmaker.workspace;

import android.content.Context;
import android.graphics.BitmapFactory;
import androidx.viewpager.widget.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.io.File;

public class SliderPagerAdapter extends PagerAdapter {

    private Context context;
    private File[] items;

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public SliderPagerAdapter(Context context2, File[] fileArr) {
        this.items = fileArr;
        this.context = context2;
    }

    public int getCount() {
        return this.items.length;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(this.context);
        imageView.setImageBitmap(BitmapFactory.decodeFile(this.items[i].getAbsolutePath()));
        viewGroup.addView(imageView);
        return imageView;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
