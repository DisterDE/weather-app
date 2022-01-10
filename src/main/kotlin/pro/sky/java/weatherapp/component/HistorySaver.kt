package pro.sky.java.weatherapp.component

import pro.sky.java.weatherapp.domain.HistoryRecord

interface HistorySaver {
    suspend fun saveRecord(record: HistoryRecord)
}