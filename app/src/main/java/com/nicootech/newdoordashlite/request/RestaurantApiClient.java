package com.nicootech.newdoordashlite.request;

import android.util.Log;

import com.nicootech.newdoordashlite.model.Restaurant;
import com.nicootech.newdoordashlite.request.responses.RestaurantResponse;
import com.nicootech.newdoordashlite.util.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Query;

public class RestaurantApiClient {

    private static final String TAG = "RestaurantApiClient";
    private static final int NETWORK_TIMEOUT = 3000 ;
    private MutableLiveData<List<Restaurant>> mRestaurants;
    private RetrieveRestaurantRunnable mRetrieveRestaurantRunnable;

    private static RestaurantApiClient instance;

    public static RestaurantApiClient getInstance(){
        if(instance == null){
            instance = new RestaurantApiClient();
        }
        return instance;
    }
    public RestaurantApiClient(){
        mRestaurants = new MutableLiveData<>();
    }

    public LiveData<List<Restaurant>> getRestaurants(){
        return mRestaurants;
    }

    public void searchRestaurantApi(double lat, double lng, int offset, int limit){
        if(mRetrieveRestaurantRunnable != null) mRetrieveRestaurantRunnable = null;
        mRetrieveRestaurantRunnable = new RetrieveRestaurantRunnable(lat,lng,offset,limit);
        final Future handler = AppExecutors.getInstance().networkIO().submit(mRetrieveRestaurantRunnable);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                handler.cancel(true);
            }
        }, NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    private class RetrieveRestaurantRunnable implements Runnable{

        private double lat;
        private double lng;
        private int offset;
        private int limit;
        boolean cancelRequest;

        public RetrieveRestaurantRunnable(double lat, double lng, int offset, int limit) {
            this.lat = lat;
            this.lng = lng;
            this.offset = offset;
            this.limit = limit;
            cancelRequest = false;
        }

        @Override
        public void run() {
            try {
                Response response = getRestaurant(lat,lng,offset,limit).execute();
                if(cancelRequest== true) return;
                if(response.code()== 200){
                    List<Restaurant> list = new ArrayList<>(((RestaurantResponse)response.body()).getStores());
//                    if(offset == 0) mRestaurants.postValue(list);
//                    else {
//                        List<Restaurant>currentRestaurant = mRestaurants.getValue();
//                        currentRestaurant.addAll(list);
//                    }
                    mRestaurants.postValue(list);


                }
                else{
                    String error = response.errorBody().string();
                    Log.d(TAG, "run: "+error);
                    mRestaurants.postValue(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                mRestaurants.postValue(null);
            }

        }

        private Call<RestaurantResponse> getRestaurant(double lat, double lng, int offset, int limit){
            return ServiceGenerator.getRestaurantListApi().getRestaurantList(
                    Constants.LAT, Constants.LNG, offset,limit);
        }
        private void cancelRequest(){
            Log.d(TAG, "cancelRequest: canceling the search request. ");
            cancelRequest = true;
        }
    }
}
