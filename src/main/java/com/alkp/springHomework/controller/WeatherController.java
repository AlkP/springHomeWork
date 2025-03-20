package com.alkp.springHomework.controller;

import com.alkp.springHomework.Weather;
import com.alkp.springHomework.dto.Current;
import com.alkp.springHomework.dto.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;

@RestController
public class WeatherController {
    @Value("${spring.application.weatherKey}")
    private String weatherKey;

    @GetMapping("/api/v1/weather/{query}")
    public Current query(@PathVariable("query") String query) throws IOException {
        Response<WeatherApiResponse> response = Weather
                .instance()
                .current(weatherKey, query)
                .execute();
        return response.body().getCurrent();
    }
}
