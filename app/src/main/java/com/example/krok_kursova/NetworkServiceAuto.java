package com.example.krok_kursova;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkServiceAuto {
    private static NetworkServiceAuto mInstance;
    private static final String BASE_URL = "http://10.0.2.2:8080/09_04_Web_exploded/";

    private Retrofit mRetrofit;

    private NetworkServiceAuto() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkServiceAuto getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkServiceAuto();
        }
        return mInstance;
    }

    public JSONPlaceAutoApi getJSONApi() {
        return mRetrofit.create(JSONPlaceAutoApi.class);
    }
}
