package mehdi.me.kotlinweatherapp

import android.util.Log
import java.net.URL

/**
 * Copyright (c) 2019 Cefalo AS. All rights reserved.
 *
 */
class Request(val url: String) {

    fun run() {
        val foreCastJsonStr = URL(url).readText()
        Log.i(javaClass.simpleName, foreCastJsonStr)
    }
}