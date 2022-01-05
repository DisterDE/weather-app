package pro.sky.java.weatherapp.component

import kotlinx.coroutines.reactor.awaitSingle
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import pro.sky.java.weatherapp.domain.Weather

@Component
class OwmRestClientImpl : OwmRestClient {

    @Value("\${owm.api.key}")
    private lateinit var apiKey: String

    private val log = KotlinLogging.logger { }

    @Cacheable("weather_forecasts")
    override suspend fun getForecast(cityName: String): Weather {
        log.info("City doesn't exist in cache: {}", cityName)
        return WebClient.create()
            .get()
            .uri { uriBuilder ->
                uriBuilder.path(OWM_URL)
                    .queryParam("q", cityName)
                    .queryParam("appid", apiKey)
                    .build()
            }.retrieve()
            .bodyToMono(Weather::class.java)
            .awaitSingle()
            .also { log.info("Forecast for {} received: {}", cityName, it) }
    }

    companion object {
        private const val OWM_URL = "api.openweathermap.org/data/2.5/weather"
    }
}