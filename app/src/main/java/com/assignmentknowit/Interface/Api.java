package com.assignmentknowit.Interface;

import com.assignmentknowit.Model.OrderItems;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://api.flickr.com/services/feeds/";

    @GET("photos_public.gne?tags=street&format=json&nojsoncallback=1")
    Call<List<OrderItems>> getOrderDates();
}
