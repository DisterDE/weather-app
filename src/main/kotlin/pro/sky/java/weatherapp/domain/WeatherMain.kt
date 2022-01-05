package pro.sky.java.weatherapp.domain

import pro.sky.java.weatherapp.util.convertToCelsius
import pro.sky.java.weatherapp.util.convertToMmHg

class WeatherMain {
    var temp: Float? = null
        set(value) {
            field = value?.convertToCelsius()
        }
    var pressure: Int? = null
        set(value) {
            field = value?.convertToMmHg()
        }
    var humidity: Int? = null

    override fun toString(): String {
        return "WeatherMain(temp=$temp, pressure=$pressure, humidity=$humidity)"
    }
}