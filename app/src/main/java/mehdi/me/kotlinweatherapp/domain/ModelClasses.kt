package mehdi.me.kotlinweatherapp.domain

/**
 * Copyright (c) 2019 Cefalo AS. All rights reserved.
 *
 */

data class ForecastList(
    val city: String,
    val country: String,
    val dailyForecast:List<Forecast>)

data class Forecast(
    val date: String,
    val description: String,
    val high: Int,
    val low: Int)