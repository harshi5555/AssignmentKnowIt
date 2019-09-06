package com.assignmentknowit.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.assignmentknowit.Interface.Api;
import com.assignmentknowit.Model.OrderItems;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OrderDateViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<OrderItems>> orderList;

    //we will call this method to get the data
    public LiveData<List<OrderItems>> getOrderDates() {
        //if the list is null
        if (orderList == null) {
            orderList = new MutableLiveData<List<OrderItems>>();
            //we will load it asynchronously from server in this method
            loadDates();
        }

        //finally we will return the list
        return orderList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadDates() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<OrderItems>> call = api.getOrderDates();


        call.enqueue(new Callback<List<OrderItems>>() {
            @Override
            public void onResponse(Call<List<OrderItems>> call, Response<List<OrderItems>> response) {
                orderList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<OrderItems>> call, Throwable t) {

            }


        });
    }

}
