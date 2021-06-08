package com.nicootech.newdoordashlite;

import android.os.Bundle;
import android.view.View;

public class RestaurantListActivity extends BaseActivity {
    private static final String TAG = "RestaurantListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mProgressBar.getVisibility()== View.VISIBLE){
                    showProgressBar(false);
                }else{
                    showProgressBar(true);
                }
            }
        });
    }

}