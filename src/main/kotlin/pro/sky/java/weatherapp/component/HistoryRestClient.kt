package pro.sky.java.weatherapp.component

import pro.sky.java.weatherapp.domain.HistoryRecord

interface HistoryRestClient {
    suspend fun saveRecord(record: HistoryRecord): HistoryRecord
}