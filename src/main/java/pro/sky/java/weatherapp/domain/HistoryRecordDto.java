package pro.sky.java.weatherapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryRecordDto {
    private String cityName;
    private String result;
}
