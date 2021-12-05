package pro.sky.java.weatherapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.weatherapp.domain.WeatherDto;
import pro.sky.java.weatherapp.service.WeatherService;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // http://localhost:8080/weather/get/Paris
    @GetMapping("/get/{cityName}")
    public WeatherDto getWeather(@PathVariable String cityName){
        return weatherService.getWeatherByCity(cityName);
    }
}
