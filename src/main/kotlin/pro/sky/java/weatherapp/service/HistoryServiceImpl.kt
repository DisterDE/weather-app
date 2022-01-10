package pro.sky.java.weatherapp.service

import org.springframework.stereotype.Service
import pro.sky.java.weatherapp.component.HistorySaver
import pro.sky.java.weatherapp.domain.HistoryRecord

@Service
class HistoryServiceImpl(
    private val historySaver: HistorySaver
) : HistoryService {

    override suspend fun save(record: HistoryRecord) {
        return historySaver.saveRecord(record)
    }
}