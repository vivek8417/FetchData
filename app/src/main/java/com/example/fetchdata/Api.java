package com.example.fetchdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL="http://10.1.10.130/";
    @GET("test.php")
    Call<List<Data>> getData();
}
