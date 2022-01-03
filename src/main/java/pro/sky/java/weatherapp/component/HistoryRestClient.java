package pro.sky.java.weatherapp.component;

import pro.sky.java.weatherapp.domain.HistoryRecord;
import reactor.core.publisher.Mono;

public interface HistoryRestClient {

    Mono<HistoryRecord> saveRecord(HistoryRecord record);
}
