package pro.sky.java.weatherapp.util

import kotlin.math.roundToInt

fun Float.convertToCelsius() = this - 273.15f

fun Int.convertToMmHg() = (this * 0.75f).roundToInt()