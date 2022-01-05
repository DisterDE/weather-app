package pro.sky.java.weatherapp.service

import pro.sky.java.weatherapp.domain.HistoryRecord

interface HistoryService {
    suspend fun save(record: HistoryRecord): HistoryRecord
}