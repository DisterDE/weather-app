package pro.sky.java.weatherapp.domain

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class HistoryRecord(
    var cityName: String,
    var result: Weather
) {
    override fun toString(): String {
        return jacksonObjectMapper().writeValueAsString(this)
    }
}