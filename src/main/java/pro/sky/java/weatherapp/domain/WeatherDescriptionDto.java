package pro.sky.java.weatherapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherDescriptionDto {
    private String main;
    private String icon;
}
