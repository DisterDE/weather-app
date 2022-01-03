package pro.sky.java.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import pro.sky.java.weatherapp.handler.WeatherHandler;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
@EnableCaching
public class WeatherAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> router(WeatherHandler handler) {
        return route()
                .GET("/get/{cityName}", handler::get)
                .build();
    }
}
