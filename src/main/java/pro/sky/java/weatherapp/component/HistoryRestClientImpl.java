package pro.sky.java.weatherapp.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import pro.sky.java.weatherapp.domain.HistoryRecord;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class HistoryRestClientImpl implements HistoryRestClient {

    @Value("${history.url}")
    private String historyUrl;

    @Override
    public Mono<HistoryRecord> saveRecord(HistoryRecord record) {
        return WebClient.create()
                .post()
                .uri(historyUrl)
                .body(BodyInserters.fromValue(record))
                .retrieve()
                .bodyToMono(HistoryRecord.class);
    }
}
