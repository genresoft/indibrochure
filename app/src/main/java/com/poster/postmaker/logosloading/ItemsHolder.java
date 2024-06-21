package com.poster.postmaker.logosloading;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.poster.postmaker.R;
import com.poster.postmaker.activity.CreateLogo;
import com.poster.postmaker.share.StaticValues;
import com.xiaopo.flying.sticker.DrawableSticker;

public class ItemsHolder extends ViewHolder implements OnClickListener {

    Context context;
    ImageView img2;

    public ItemsHolder(View view, Context context2) {
        super(view);
        this.img2 = (ImageView) view.findViewById(R.id.itemadded);
        this.img2.setOnClickListener(this);
        this.context = context2;
    }

    public void onClick(View view) {
        if (!view.equals(this.img2)) {
            return;
        }
        if (StaticValues.f79i == 1) {
            CreateLogo.stickerView.addSticker(new DrawableSticker(ContextCompat.getDrawable(this.context, StaticValues.logos[getAdapterPosition()])));
            CreateLogo.stickerView.invalidate();
            CreateLogo.logorecylerview.setVisibility(8);
        } else if (StaticValues.f79i == 2) {
            CreateLogo.stickerView.addSticker(new DrawableSticker(ContextCompat.getDrawable(this.context, StaticValues.shapes[getAdapterPosition()])));
            CreateLogo.stickerView.invalidate();
            CreateLogo.logorecylerview.setVisibility(8);
        }
    }
}
