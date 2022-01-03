package pro.sky.java.weatherapp.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pro.sky.java.weatherapp.domain.Weather;
import pro.sky.java.weatherapp.service.WeatherService;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class WeatherHandler {

    private final WeatherService service;

    @NonNull
    public Mono<ServerResponse> get(ServerRequest serverRequest) {
        String cityName = serverRequest.pathVariable("cityName");
        return ok().body(
                service.getWeatherByCity(cityName),
                Weather.class
        );
    }
}
