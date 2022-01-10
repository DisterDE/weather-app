package pro.sky.java.weatherapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.server.coRouter
import pro.sky.java.weatherapp.handler.WeatherHandler

@EnableCaching
@SpringBootApplication
class WeatherApplication {
    @Bean
    fun router(handler: WeatherHandler) = coRouter {
        GET("/get/{cityName}", handler::get)
    }
}

fun main(args: Array<String>) {
    runApplication<WeatherApplication>(*args)
}
