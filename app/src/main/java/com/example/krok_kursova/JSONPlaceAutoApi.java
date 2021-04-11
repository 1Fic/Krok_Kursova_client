package com.example.krok_kursova;

import com.example.krok_kursova.pojo.Auto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceAutoApi {
    @GET("auto/{id}")
    public Call<Auto> getAutoWithID(@Path("id") long id);

}
