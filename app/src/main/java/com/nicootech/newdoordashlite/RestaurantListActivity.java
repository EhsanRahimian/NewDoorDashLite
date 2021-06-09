package com.nicootech.newdoordashlite;

import android.os.Bundle;

import com.nicootech.newdoordashlite.model.Restaurant;
import com.nicootech.newdoordashlite.viewmodel.RestaurantListViewModel;

import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


public class RestaurantListActivity extends BaseActivity {

    private static final String TAG = "RestaurantListActivity";

    private RestaurantListViewModel mRestaurantListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        mRestaurantListViewModel = new ViewModelProvider(this).get(RestaurantListViewModel.class);

        subscribeObserver();

    }

    private void subscribeObserver(){
        mRestaurantListViewModel.getRestaurant().observe(this, new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(List<Restaurant> restaurants) {

            }
        });
    }
//    private void testRetrofitRequest(){
//        RestaurantListApi restaurantListApi = ServiceGenerator.getRestaurantListApi();
//        Call<RestaurantResponse> responseCall = restaurantListApi
//                .getRestaurantList(Constants.LAT, Constants.LNG, 0, 50);
//        responseCall.enqueue(new Callback<RestaurantResponse>() {
//            @Override
//            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
//                if(response.code() == 200){
//                    Log.d(TAG, "onResponse: "+response.body().toString());
//                    List<Restaurant> restaurants = new ArrayList<>(response.body().getStores());
//                    for(Restaurant restaurant: restaurants){
//                        Log.d(TAG, "onResponse: "+restaurant.getName());
//                    }
//                    //Log.d(TAG, "onResponse: RETRIEVED RECIPE: "+ restaurants.toString());
//                }
//                else{
//                    try {
//                        Log.d(TAG, "onResponse: "+response.errorBody().string());
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RestaurantResponse> call, Throwable t) {
//
//            }
//        });
//    }
}