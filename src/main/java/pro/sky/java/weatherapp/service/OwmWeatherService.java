package pro.sky.java.weatherapp.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.sky.java.weatherapp.component.OwmRestClient;
import pro.sky.java.weatherapp.domain.HistoryRecord;
import pro.sky.java.weatherapp.domain.Weather;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class OwmWeatherService implements WeatherService {

    private final OwmRestClient restClient;
    private final HistoryService historyService;

    public OwmWeatherService(
            OwmRestClient restClient,
            HistoryService historyService
    ) {
        this.restClient = restClient;
        this.historyService = historyService;
    }

    @Override
    @SneakyThrows
    public Mono<Weather> getWeatherByCity(String cityName) {
        log.info("Trying to retrieve weather forecast: {}", cityName);
        return restClient.getForecast(cityName)
                .doOnSuccess(f ->
                        historyService.save(new HistoryRecord(cityName, f))
                );
    }
}
