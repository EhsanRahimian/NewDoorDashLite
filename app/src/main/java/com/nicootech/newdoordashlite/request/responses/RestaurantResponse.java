package com.nicootech.newdoordashlite.request.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nicootech.newdoordashlite.model.Restaurant;

import java.util.List;

public class RestaurantResponse {

    @SerializedName("stores")
    @Expose()
    private List<Restaurant>stores;

    public List<Restaurant>getStores(){
        return stores;
    }

    @Override
    public String toString() {
        return "RestaurantResponse{" +
                "num_results=" +
                ", stores=" +
                stores +
                '}';
    }
}
