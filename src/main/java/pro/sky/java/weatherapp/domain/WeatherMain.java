package pro.sky.java.weatherapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import pro.sky.java.weatherapp.util.WeatherUtils;

@Data
@NoArgsConstructor
public class WeatherMain {
    private Integer temp;
    private Integer pressure;
    private Integer humidity;

    public void setTemp(Float temp) {
        if (temp != null) {
            this.temp = WeatherUtils.convertToCelsius(temp);
        }
    }

    public void setPressure(Integer pressure) {
        if (pressure != null) {
            this.pressure = WeatherUtils.convertToMmHg(pressure);
        }
    }
}
