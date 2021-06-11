package com.nicootech.newdoordashlite.adapter;

import android.view.View;
import android.widget.TextView;

import com.nicootech.newdoordashlite.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantViewHolder extends RecyclerView.ViewHolder {

    TextView name, type;
    AppCompatImageView image;


    public RestaurantViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.text_name);
        type = itemView.findViewById(R.id.text_type);
    }


}
