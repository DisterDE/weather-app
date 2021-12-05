package pro.sky.java.weatherapp.component;

import pro.sky.java.weatherapp.domain.HistoryRecordDto;

public interface HistoryRestClient {

    HistoryRecordDto saveRecord(HistoryRecordDto record);
}
