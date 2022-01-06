package pro.sky.java.weatherapp.service

import mu.KotlinLogging
import org.springframework.stereotype.Service
import pro.sky.java.weatherapp.component.HistoryRestClient
import pro.sky.java.weatherapp.domain.HistoryRecord

@Service
class HistoryServiceImpl(
    private val historyRestClient: HistoryRestClient
) : HistoryService {

    private val log = KotlinLogging.logger { }

    override suspend fun save(record: HistoryRecord): HistoryRecord {
        log.info("Trying to save history record: {}", record)
        return historyRestClient.saveRecord(record)
            .also { log.info { "History record is saved: $it" } }
    }
}