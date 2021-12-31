package pro.sky.java.weatherapp.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.sky.java.weatherapp.component.OwmRestClient;
import pro.sky.java.weatherapp.domain.HistoryRecord;
import pro.sky.java.weatherapp.domain.Weather;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class OwmWeatherService implements WeatherService {

    private final OwmRestClient restClient;
    private final HistoryService historyService;

    @Override
    @SneakyThrows
    public Mono<Weather> getWeatherByCity(String cityName) {
        return restClient.getForecast(cityName)
                .doOnSuccess(f ->
                        historyService.save(new HistoryRecord(cityName, f))
                );
    }
}
