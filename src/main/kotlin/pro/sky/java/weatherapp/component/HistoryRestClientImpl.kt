package pro.sky.java.weatherapp.component

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import pro.sky.java.weatherapp.domain.HistoryRecord

@Component
class HistoryRestClientImpl : HistoryRestClient {

    @Value("\${history.url}")
    private lateinit var historyUrl: String

    override suspend fun saveRecord(record: HistoryRecord): HistoryRecord {
        return WebClient.create()
            .post()
            .uri(historyUrl)
            .body(BodyInserters.fromValue(record))
            .retrieve()
            .bodyToMono(HistoryRecord::class.java)
            .awaitSingle()
    }
}