package pro.sky.java.weatherapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import pro.sky.java.weatherapp.util.WeatherUtils;

@Data
@NoArgsConstructor
public class WeatherMainDto {
    private Integer temp;
    private Integer pressure;
    private Integer humidity;

    public void setTemp(Float temp) {
        if (temp != null) {
            this.temp = WeatherUtils.convertToCelsius(temp);
        }
    }
}
