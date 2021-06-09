package com.nicootech.newdoordashlite.request;

import android.util.Log;

import com.nicootech.newdoordashlite.model.Restaurant;

import java.util.List;

public class Testing {
    public static void printingRestaurant(List<Restaurant> list , String tag){
        for (Restaurant restaurant :list){
            Log.d(tag, "onChanged: "+restaurant.getName());
        }
    }
}
