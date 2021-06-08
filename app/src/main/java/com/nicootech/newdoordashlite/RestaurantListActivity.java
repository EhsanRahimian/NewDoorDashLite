package com.nicootech.newdoordashlite;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.nicootech.newdoordashlite.model.Restaurant;
import com.nicootech.newdoordashlite.request.RestaurantListApi;
import com.nicootech.newdoordashlite.request.ServiceGenerator;
import com.nicootech.newdoordashlite.request.responses.RestaurantResponse;
import com.nicootech.newdoordashlite.util.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RestaurantListActivity extends BaseActivity {

    private static final String TAG = "RestaurantListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testRetrofitRequest();
            }
        });
    }
    private void testRetrofitRequest(){
        RestaurantListApi restaurantListApi = ServiceGenerator.getRestaurantListApi();
        Call<RestaurantResponse> responseCall = restaurantListApi
                .getRestaurantList(Constants.LAT, Constants.LNG, 0, 50);
        responseCall.enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                if(response.code() == 200){
                    Log.d(TAG, "onResponse: "+response.body().toString());
                    List<Restaurant> restaurants = new ArrayList<>(response.body().getStores());
                    for(Restaurant restaurant: restaurants){
                        Log.d(TAG, "onResponse: "+restaurant.getName());
                    }
                    //Log.d(TAG, "onResponse: RETRIEVED RECIPE: "+ restaurants.toString());
                }
                else{
                    try {
                        Log.d(TAG, "onResponse: "+response.errorBody().string());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {

            }
        });
    }
}