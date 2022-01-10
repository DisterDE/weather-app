package pro.sky.java.weatherapp.component

import mu.KotlinLogging
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import pro.sky.java.weatherapp.domain.HistoryRecord

@Component
class HistorySaverImpl(
    @Value("\${history.queue}")
    private val queueName: String,
    private val template: RabbitTemplate
) : HistorySaver {

    private val log = KotlinLogging.logger {}

    override suspend fun saveRecord(record: HistoryRecord) {
        log.info { "Sending record to history service: $record" }
        template.convertAndSend(queueName, record.toString())
        log.info { "Record sent to history service." }
    }
}