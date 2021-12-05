package pro.sky.java.weatherapp.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pro.sky.java.weatherapp.constant.OwmConstants;
import pro.sky.java.weatherapp.domain.WeatherDto;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class OwmRestClientImpl implements OwmRestClient {

    @Value("${owm.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public OwmRestClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Cacheable("weather_forecasts")
    public WeatherDto getWeather(String cityName) {
        log.info("City doesn't exist in cache: {}", cityName);
        Map<String, String> params = new HashMap<>();
        params.put("cityName", cityName);
        params.put("apiKey", apiKey);
        return restTemplate.getForObject(OwmConstants.OWM_URL, WeatherDto.class, params);
    }
}
