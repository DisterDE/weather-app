package pro.sky.java.weatherapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherDescription {
    private String main;
    private String icon;
}
