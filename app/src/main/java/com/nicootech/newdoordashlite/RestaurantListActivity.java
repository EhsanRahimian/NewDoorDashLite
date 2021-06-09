package com.nicootech.newdoordashlite;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.nicootech.newdoordashlite.model.Restaurant;
import com.nicootech.newdoordashlite.request.RestaurantListApi;
import com.nicootech.newdoordashlite.request.ServiceGenerator;
import com.nicootech.newdoordashlite.request.Testing;
import com.nicootech.newdoordashlite.request.responses.RestaurantResponse;
import com.nicootech.newdoordashlite.util.Constants;
import com.nicootech.newdoordashlite.viewmodel.RestaurantListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import retrofit2.Call;
import retrofit2.Response;


public class RestaurantListActivity extends BaseActivity {

    private static final String TAG = "RestaurantListActivity";

    private RestaurantListViewModel mRestaurantListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        mRestaurantListViewModel = new ViewModelProvider(this).get(RestaurantListViewModel.class);

        subscribeObserver();

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testRetrofitRequest();
            }
        });

    }

    private void subscribeObserver(){
        mRestaurantListViewModel.getRestaurant().observe(this, new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(List<Restaurant> restaurants) {
                if(restaurants != null){
                    Testing.printingRestaurant(restaurants,"restaurants test");
                }
            }
        });
    }
    private void searchRestaurantApi(double lat, double lng, int offset, int limit){
        mRestaurantListViewModel.searchRestaurantApi(lat,lng,offset,limit);
    }
    private void testRetrofitRequest(){
        searchRestaurantApi(Constants.LAT,Constants.LNG,0,50);
    }
}