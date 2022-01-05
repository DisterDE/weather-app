package pro.sky.java.weatherapp.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mu.KotlinLogging
import org.springframework.stereotype.Service
import pro.sky.java.weatherapp.component.OwmRestClient
import pro.sky.java.weatherapp.domain.HistoryRecord
import pro.sky.java.weatherapp.domain.Weather

@Service
class OwmWeatherService(
    private val restClient: OwmRestClient,
    private val historyService: HistoryService
) : WeatherService {

    private val log = KotlinLogging.logger { }

    override suspend fun getWeatherByCity(cityName: String): Weather {
        log.info("Trying to get a forecast for {}", cityName)
        return restClient.getForecast(cityName).also {
            withContext(Dispatchers.IO) {
                launch {
                    historyService.save(HistoryRecord(cityName, it))
                        .also { log.info { "History record saved $it" } }
                }
            }
        }
    }
}