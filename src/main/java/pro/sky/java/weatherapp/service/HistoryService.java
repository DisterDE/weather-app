package pro.sky.java.weatherapp.service;

import pro.sky.java.weatherapp.domain.HistoryRecordDto;

public interface HistoryService {
    HistoryRecordDto save(HistoryRecordDto record);
}
