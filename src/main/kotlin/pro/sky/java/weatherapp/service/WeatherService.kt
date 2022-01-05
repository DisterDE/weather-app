package pro.sky.java.weatherapp.service

import pro.sky.java.weatherapp.domain.Weather

interface WeatherService {
    suspend fun getWeatherByCity(cityName: String): Weather
}