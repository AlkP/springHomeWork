package com.alkp.springHomework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Weather {
    public static final String HOST = "https://api.weatherapi.com";
    private static WeatherApi api;

    private static WeatherApi init() {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        WeatherApi api = retrofit.create(WeatherApi.class);
        return api;
    }

    public static WeatherApi instance() {
        if (api == null) {
            api = init();
        }

        return api;
    }
}
