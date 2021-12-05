package pro.sky.java.weatherapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import pro.sky.java.weatherapp.component.OwmRestClient;
import pro.sky.java.weatherapp.domain.HistoryRecordDto;
import pro.sky.java.weatherapp.domain.WeatherDto;

@Service
public class OwmWeatherService implements WeatherService {

    private final OwmRestClient restClient;
    private final ObjectMapper objectMapper;
    private final HistoryService historyService;

    public OwmWeatherService(
            OwmRestClient restClient,
            ObjectMapper objectMapper,
            HistoryService historyService
    ) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
        this.historyService = historyService;
    }

    @Override
    @SneakyThrows
    public WeatherDto getWeatherByCity(String cityName) {
        WeatherDto weather = restClient.getWeather(cityName);
        String weatherJson = objectMapper.writeValueAsString(weather);
        HistoryRecordDto historyRecordDto = new HistoryRecordDto(cityName, weatherJson);
        historyService.save(historyRecordDto);
        return weather;
    }
}
