package pro.sky.java.weatherapp.domain

class WeatherDescription(
    var main: String? = null,
    var icon: String? = null
) {
    override fun toString(): String {
        return "WeatherDescription(main=$main, icon=$icon)"
    }
}