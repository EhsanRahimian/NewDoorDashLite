package com.nicootech.newdoordashlite.request;

import com.nicootech.newdoordashlite.model.Restaurant;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class RestaurantApiClient {

    private MutableLiveData<List<Restaurant>> mRestaurants;

    private static RestaurantApiClient instance;

    public static RestaurantApiClient getInstance(){
        if(instance == null){
            instance = new RestaurantApiClient();
        }
        return instance;
    }
    public RestaurantApiClient(){
        mRestaurants = new MutableLiveData<>();
    }

    public LiveData<List<Restaurant>> getRestaurant(){
        return mRestaurants;
    }
}
