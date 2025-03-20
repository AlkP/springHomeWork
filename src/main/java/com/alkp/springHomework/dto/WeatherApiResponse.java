package com.alkp.springHomework.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherApiResponse {
    private Location location;
    private Current current;
}
