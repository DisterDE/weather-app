package pro.sky.java.weatherapp.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pro.sky.java.weatherapp.domain.HistoryRecordDto;

@Component
public class HistoryRestClientImpl implements HistoryRestClient {

    private final RestTemplate restTemplate;

    @Value("${history.url}")
    private String historyUrl;

    public HistoryRestClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public HistoryRecordDto saveRecord(HistoryRecordDto record) {
        HttpEntity<HistoryRecordDto> requestEntity = new HttpEntity<>(record);
        return restTemplate.postForObject(historyUrl, requestEntity, HistoryRecordDto.class);
    }
}
