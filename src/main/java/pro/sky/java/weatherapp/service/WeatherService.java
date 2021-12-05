package pro.sky.java.weatherapp.service;

import pro.sky.java.weatherapp.domain.WeatherDto;

public interface WeatherService {
    WeatherDto getWeatherByCity(String cityName);
}
