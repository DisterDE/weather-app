package pro.sky.java.weatherapp.component;

import pro.sky.java.weatherapp.domain.Weather;
import reactor.core.publisher.Mono;

public interface OwmRestClient {

    Mono<Weather> getForecast(String cityName);
}
