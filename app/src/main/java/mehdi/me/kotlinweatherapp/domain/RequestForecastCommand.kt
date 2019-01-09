package mehdi.me.kotlinweatherapp.domain

import mehdi.me.kotlinweatherapp.ForecastRequest

/**
 * Copyright (c) 2019 Cefalo AS. All rights reserved.
 *
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
            forecastRequest.execute())
    }
}