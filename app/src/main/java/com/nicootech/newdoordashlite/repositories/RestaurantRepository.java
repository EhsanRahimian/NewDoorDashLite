package com.nicootech.newdoordashlite.repositories;

import com.nicootech.newdoordashlite.model.Restaurant;
import com.nicootech.newdoordashlite.request.RestaurantApiClient;

import java.util.List;

import androidx.lifecycle.LiveData;


public class RestaurantRepository {

    private RestaurantApiClient mRestaurantApiClient;

    private static RestaurantRepository instance;

    public static RestaurantRepository getInstance(){
        if(instance == null){
            instance = new RestaurantRepository();
        }
        return instance;
    }

    public RestaurantRepository() {
        mRestaurantApiClient = RestaurantApiClient.getInstance();
    }

    public LiveData<List<Restaurant>> getRestaurants(){
        return mRestaurantApiClient.getRestaurants();
    }
    public void searchRestaurantApi(double lat, double lng, int offset, int limit){
        mRestaurantApiClient.searchRestaurantApi(lat,lng,offset,limit);
    }

}
