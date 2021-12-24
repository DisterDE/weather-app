package pro.sky.java.weatherapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherMainDto {
    private Integer temp;
    private Integer pressure;
    private Integer humidity;
}
