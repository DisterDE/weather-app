package pro.sky.java.weatherapp.component;

import pro.sky.java.weatherapp.domain.WeatherDto;

public interface OwmRestClient {

    WeatherDto getWeather(String cityName);
}
