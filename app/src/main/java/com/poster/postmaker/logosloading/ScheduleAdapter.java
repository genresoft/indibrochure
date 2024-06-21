package com.poster.postmaker.logosloading;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.poster.postmaker.R;

import java.util.ArrayList;

public class ScheduleAdapter extends Adapter<ItemsHolder> {

    Context context;
    ArrayList<ItemsCons> items;

    public long getItemId(int i) {
        return 0;
    }

    public ScheduleAdapter(ArrayList<ItemsCons> arrayList, Context context2) {
        this.context = context2;
        this.items = arrayList;
    }

    @NonNull
    public ItemsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemsHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false), this.context);
    }

    public void onBindViewHolder(@NonNull ItemsHolder itemsHolder, int i) {
        Glide.with(this.context).load(Integer.valueOf(((ItemsCons) this.items.get(i)).getImg2())).into(itemsHolder.img2);
    }

    public int getItemCount() {
        return this.items.size();
    }
}
