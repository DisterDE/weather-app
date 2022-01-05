package pro.sky.java.weatherapp.util;

public class WeatherUtils {

    private WeatherUtils() {
    }

    public static int convertToCelsius(Float kelvinTemp) {
        return Math.round(kelvinTemp - 273.15f);
    }

    public static int convertToMmHg(Integer hPa) {
        return Math.round(hPa * 0.75f);
    }
}
