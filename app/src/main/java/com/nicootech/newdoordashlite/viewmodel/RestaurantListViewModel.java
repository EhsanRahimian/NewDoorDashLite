package com.nicootech.newdoordashlite.viewmodel;

import com.nicootech.newdoordashlite.model.Restaurant;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RestaurantListViewModel extends ViewModel {

    private MutableLiveData<List<Restaurant>> mRestaurant = new MutableLiveData<>();

    public RestaurantListViewModel() {
    }
    public LiveData<List<Restaurant>> getRestaurant(){
        return mRestaurant;
    }
}
