package com.nicootech.newdoordashlite.viewmodel;

import com.nicootech.newdoordashlite.model.Restaurant;
import com.nicootech.newdoordashlite.repositories.RestaurantRepository;

import java.util.List;
import java.util.Observable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RestaurantListViewModel extends ViewModel {

    private  RestaurantRepository mRestaurantRepository;

    public RestaurantListViewModel() {
        mRestaurantRepository = RestaurantRepository.getInstance();
    }
    public LiveData<List<Restaurant>> getRestaurant(){

        return mRestaurantRepository.getRestaurants();
    }
    public void searchRestaurantApi(double lat, double lng, int offset, int limit){
        mRestaurantRepository.searchRestaurantApi(lat,lng,offset,limit);
    }
}
