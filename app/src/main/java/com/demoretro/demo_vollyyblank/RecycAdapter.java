package com.demoretro.demo_vollyyblank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.ViewHolder> {

    Activity activity;
    ArrayList<ModelClass> modelClasses;

    public RecycAdapter(Activity activity, ArrayList<ModelClass> modelClasses) {
        this.activity = activity;
        this.modelClasses = modelClasses;
    }

    @NonNull
    @Override
    public RecycAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater layoutInflater;
        int i2;
        if (viewType == 0) {
            layoutInflater = LayoutInflater.from(parent.getContext());
            i2 = R.layout.iteam_blanklayout;
        } else if (viewType != 1) {
            view = null;
            return new ViewHolder(view);
        } else {
            layoutInflater = LayoutInflater.from(parent.getContext());
            i2 = R.layout.iteam_layout;
        }
        view = layoutInflater.inflate(i2, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecycAdapter.ViewHolder holder, int position) {

        ViewHolder viewHolder2 = (ViewHolder) holder;
        int itemViewType = holder.getItemViewType();

        if (itemViewType == 0) {
//            AppManage.getInstance(activity).showNative((ViewGroup) viewHolder2.native_adplaceholder, AppManage.ADMOB_N[0], AppManage.ADX_N[0]);

        } else if (itemViewType == 1) {
            holder.view.setText(modelClasses.get(position).title);

        }

    }

    @Override
    public int getItemCount() {
        return modelClasses.size();
    }

    public int getItemViewType(int i) {
        return this.modelClasses.get(i) != null ? 1 : 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView view;

        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.txt_iteam);
            cardView = itemView.findViewById(R.id.cardview_blank);
        }
    }

}
