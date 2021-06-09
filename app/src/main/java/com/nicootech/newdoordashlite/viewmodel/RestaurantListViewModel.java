package com.nicootech.newdoordashlite.viewmodel;

import com.nicootech.newdoordashlite.model.Restaurant;
import com.nicootech.newdoordashlite.repositories.RestaurantRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RestaurantListViewModel extends ViewModel {

    private  RestaurantRepository mRestaurantRepository;

    public RestaurantListViewModel() {
        mRestaurantRepository = RestaurantRepository.getInstance();
    }
    public LiveData<List<Restaurant>> getRestaurant(){

        return mRestaurantRepository.getRestaurant();
    }
}
