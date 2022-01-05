package pro.sky.java.weatherapp.domain

class Weather {
    var name: String? = null
    var main: WeatherMain? = null
    var weather: List<WeatherDescription>? = null

    override fun toString(): String {
        return "Weather(name=$name, main=$main, weather=$weather)"
    }
}