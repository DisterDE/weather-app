package pro.sky.java.weatherapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.sky.java.weatherapp.component.HistoryRestClient;
import pro.sky.java.weatherapp.domain.HistoryRecordDto;

@Slf4j
@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRestClient restClient;

    public HistoryServiceImpl(HistoryRestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public HistoryRecordDto save(HistoryRecordDto record) {
        log.info("Request history saved. {}", record);
        return restClient.saveRecord(record);
    }
}
