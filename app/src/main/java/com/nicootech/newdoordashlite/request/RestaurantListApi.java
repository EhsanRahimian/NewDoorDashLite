package com.nicootech.newdoordashlite.request;

import com.nicootech.newdoordashlite.request.responses.RestaurantResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestaurantListApi {

    //Get => https://api.doordash.com/v1/store_feed/?lat=37.422740&lng=-122.139956&offset=0&limit=50
    @GET("/v1/store_feed/")
     Call<RestaurantResponse> getRestaurantList(
            @Query("lat") double lat,
            @Query("lng") double lng,
            @Query("offset") int offset,
            @Query("limit") int limit
    );
}
