package pro.sky.java.weatherapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherDto {
    private String name;
    private WeatherMainDto main;
    private WeatherDescriptionDto weather;

    public void setWeather(WeatherDescriptionDto[] weatherDescriptions) {
        weather = weatherDescriptions[0];
    }
}
