package pro.sky.java.weatherapp.domain;

import lombok.Data;

@Data
public class HistoryRecordDto {
    private String cityName;
    private String result;

    public HistoryRecordDto() {
    }

    public HistoryRecordDto(String cityName, String result) {
        this.cityName = cityName;
        this.result = result;
    }
}
