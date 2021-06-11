package com.nicootech.newdoordashlite.adapter;

import android.view.View;
import android.widget.TextView;

import com.nicootech.newdoordashlite.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView name, type;
    AppCompatImageView image;
    OnRestaurantListener onRestaurantListener;


    public RestaurantViewHolder(@NonNull View itemView,OnRestaurantListener onRestaurantListener) {
        super(itemView);
        this.onRestaurantListener = onRestaurantListener;
        name = itemView.findViewById(R.id.text_name);
        type = itemView.findViewById(R.id.text_type);
        image = itemView.findViewById(R.id.image_logo);
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        onRestaurantListener.onRestaurantClick(getAbsoluteAdapterPosition());
    }
}
