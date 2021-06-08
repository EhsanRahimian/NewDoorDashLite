package com.nicootech.newdoordashlite.request;

import com.nicootech.newdoordashlite.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = retrofitBuilder.build();

    private static RestaurantListApi restaurantListApi = retrofit.create(RestaurantListApi.class);

    public static RestaurantListApi getRestaurantListApi(){
        return  restaurantListApi;
    }
}
