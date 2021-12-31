package pro.sky.java.weatherapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.sky.java.weatherapp.component.HistoryRestClient;
import pro.sky.java.weatherapp.domain.HistoryRecord;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRestClient historyRestClient;

    @Override
    public Mono<HistoryRecord> save(HistoryRecord record) {
        log.info("Trying to save history record: {}", record);
        return historyRestClient.saveRecord(record)
                .doOnError(e -> log.warn("Can't save history record: {}", record, e))
                .doOnSuccess(res -> log.info("History record is saved: {}", res));
    }
}
