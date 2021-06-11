package com.nicootech.newdoordashlite;

import android.os.Bundle;
import android.util.Log;

import com.nicootech.newdoordashlite.adapter.OnRestaurantListener;
import com.nicootech.newdoordashlite.adapter.RestaurantRecyclerAdapter;
import com.nicootech.newdoordashlite.model.Restaurant;

import com.nicootech.newdoordashlite.request.Testing;
import com.nicootech.newdoordashlite.util.Constants;
import com.nicootech.newdoordashlite.viewmodel.RestaurantListViewModel;

import java.util.List;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class RestaurantListActivity extends BaseActivity implements OnRestaurantListener {

    private static final String TAG = "RestaurantListActivity";

    private RestaurantListViewModel mRestaurantListViewModel;
    private RecyclerView mRecyclerView;
    private RestaurantRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        mRecyclerView = findViewById(R.id.restaurant_list);

        mRestaurantListViewModel = new ViewModelProvider(this).get(RestaurantListViewModel.class);

        initRecyclerView();
        subscribeObserver();
        testRetrofitRequest();
    }

    private void subscribeObserver(){
        mRestaurantListViewModel.getRestaurant().observe(this, new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(List<Restaurant> restaurants) {
                if(restaurants != null){
                    Testing.printingRestaurant(restaurants,"restaurants test");

                }
                mAdapter.setRestaurants(restaurants);
            }
        });
    }

    private void initRecyclerView(){
        mAdapter = new RestaurantRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
//    private void searchRestaurantApi(double lat, double lng, int offset, int limit){
//        mRestaurantListViewModel.searchRestaurantApi(lat,lng,offset,limit);
//    }
    private void testRetrofitRequest(){
        mRestaurantListViewModel.searchRestaurantApi(Constants.LAT,Constants.LNG,0,50);
    }

    @Override
    public void onRestaurantClick(int position) {

        Log.d(TAG, "onRecipeClick: clicked. " + position);
    }
}