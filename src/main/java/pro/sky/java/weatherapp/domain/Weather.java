package pro.sky.java.weatherapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Weather {
    private String name;
    private WeatherMain main;
    private WeatherDescription weather;

    public void setWeather(WeatherDescription[] weatherDescriptions) {
        weather = weatherDescriptions[0];
    }
}
