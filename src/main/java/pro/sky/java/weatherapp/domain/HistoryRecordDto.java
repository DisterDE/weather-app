package pro.sky.java.weatherapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HistoryRecordDto {
    private String cityName;
    private String result;

    public HistoryRecordDto(String cityName, String result) {
        this.cityName = cityName;
        this.result = result;
    }
}
