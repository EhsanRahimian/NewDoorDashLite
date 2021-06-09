package com.nicootech.newdoordashlite.repositories;

import com.nicootech.newdoordashlite.model.Restaurant;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class RestaurantRepository {
    private static RestaurantRepository instance;
    private MutableLiveData<List<Restaurant>> mRestaurant;


    public static RestaurantRepository getInstance(){
        if(instance == null){
            instance = new RestaurantRepository();
        }
        return instance;
    }

    public RestaurantRepository() {
        mRestaurant = new MutableLiveData<>();
    }

    public LiveData<List<Restaurant>> getRestaurant(){
        return mRestaurant;
    }

}
