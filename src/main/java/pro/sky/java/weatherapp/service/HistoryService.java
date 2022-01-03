package pro.sky.java.weatherapp.service;

import pro.sky.java.weatherapp.domain.HistoryRecord;
import reactor.core.publisher.Mono;

public interface HistoryService {
    Mono<HistoryRecord> save(HistoryRecord record);
}
