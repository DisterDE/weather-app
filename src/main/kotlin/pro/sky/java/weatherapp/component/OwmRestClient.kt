package pro.sky.java.weatherapp.component

import pro.sky.java.weatherapp.domain.Weather

interface OwmRestClient {
    suspend fun getForecast(cityName: String): Weather
}