package pro.sky.java.weatherapp.service;

import pro.sky.java.weatherapp.domain.Weather;
import reactor.core.publisher.Mono;

public interface WeatherService {
    Mono<Weather> getWeatherByCity(String cityName);
}
