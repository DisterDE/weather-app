package pro.sky.java.weatherapp.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pro.sky.java.weatherapp.domain.Weather;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class OwmRestClientImpl implements OwmRestClient {

    private static final String OWM_URL = "api.openweathermap.org/data/2.5/weather?q={cityName}&appid={apiKey}";

    @Value("${owm.api.key}")
    private String apiKey;

    @Override
    @Cacheable("weather_forecasts")
    public Mono<Weather> getForecast(String cityName) {
        log.info("City doesn't exist in cache: {}", cityName);
        return WebClient.create()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(OWM_URL)
                        .build(cityName, apiKey))
                .retrieve()
                .bodyToMono(Weather.class)
                .doOnError(e -> log.warn("Can't receive forecast for {}", cityName, e))
                .doOnSuccess(f -> log.info("Forecast for {} received: {}", cityName, f));
    }
}
