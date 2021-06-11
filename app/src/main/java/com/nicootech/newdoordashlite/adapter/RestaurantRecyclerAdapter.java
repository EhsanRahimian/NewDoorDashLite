package com.nicootech.newdoordashlite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nicootech.newdoordashlite.R;
import com.nicootech.newdoordashlite.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Restaurant> mRestaurants;
    private OnRestaurantListener mOnRestaurantListener;

    public RestaurantRecyclerAdapter(OnRestaurantListener onRestaurantListener) {
        mOnRestaurantListener = onRestaurantListener;
        mRestaurants = new ArrayList<>();
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_restaurant_list_item,viewGroup,false);
        return new RestaurantViewHolder(view, mOnRestaurantListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RequestOptions requestOptions = new RequestOptions()
                .centerCrop()
                .error(R.drawable.ic_launcher_background);


        Glide.with(((RestaurantViewHolder)viewHolder).itemView)
                .setDefaultRequestOptions(requestOptions)
                .load(mRestaurants.get(i).getCover_img_url())
                .into(((RestaurantViewHolder)viewHolder).image);

        ((RestaurantViewHolder)viewHolder).name.setText(mRestaurants.get(i).getName());
        ((RestaurantViewHolder)viewHolder).type.setText(mRestaurants.get(i).getDescription());
    }

    @Override
    public int getItemCount() {

            return mRestaurants.size();


    }

    public void setRestaurants(List<Restaurant> restaurants){
        mRestaurants = restaurants;
        notifyDataSetChanged();
    }
}
