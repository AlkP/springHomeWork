package com.alkp.springHomework.controller;

import com.alkp.springHomework.Weather;
import com.alkp.springHomework.dto.Current;
import com.alkp.springHomework.dto.WeatherApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;

@RestController
public class WeatherController {
    @Value("${spring.application.weatherKey}")
    private String weatherKey;

    @GetMapping("/api/v1/weather")
    public Current weather(@RequestParam(required = false) String query, HttpServletRequest req) {
        String q = query == null ? req.getRemoteAddr() : query;
        try {
            Response<WeatherApiResponse> response = Weather
                    .instance()
                    .current(weatherKey, q)
                    .execute();

            return response.body().getCurrent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
