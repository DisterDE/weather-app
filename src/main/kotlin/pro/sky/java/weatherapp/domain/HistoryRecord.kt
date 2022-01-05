package pro.sky.java.weatherapp.domain

class HistoryRecord(
    var cityName: String,
    var result: Weather
) {
    override fun toString(): String {
        return "HistoryRecord(cityName='$cityName', result=$result)"
    }
}