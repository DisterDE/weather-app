package pro.sky.java.weatherapp.handler

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import pro.sky.java.weatherapp.service.WeatherService

@Component
class WeatherHandler(
    private val service: WeatherService
) {
    suspend fun get(serverRequest: ServerRequest): ServerResponse {
        val cityName: String = serverRequest.pathVariable("cityName")
        return ok().bodyValueAndAwait(service.getWeatherByCity(cityName))
    }
}