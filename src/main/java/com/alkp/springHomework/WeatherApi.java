package com.alkp.springHomework;

import com.alkp.springHomework.dto.WeatherApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("/v1/current.json")
    Call<WeatherApiResponse> current(@Query("key") String key, @Query("q") String query);
}
