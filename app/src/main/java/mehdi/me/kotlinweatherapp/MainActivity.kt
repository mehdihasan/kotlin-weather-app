package mehdi.me.kotlinweatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import mehdi.me.kotlinweatherapp.domain.RequestForecastCommand
import org.jetbrains.anko.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    //var forecastList: RecyclerView? = null

    private val items = listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Tue 6/24 - Foggy - 21/8",
        "Wed 6/25 - Cloudy - 22/17",
        "Thurs 6/26 - Rainy - 18/11",
        "Fri 6/27 - Foggy - 21/10",
        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
        "Sun 6/29 - Sunny - 20/7"
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        fetchWeatherDataAndLoad(forecastList)
    }

    override fun onResume() {
        super.onResume()
        //fetchWeatherData()
    }

    fun fetchWeatherDataAndLoad(forecastList: RecyclerView) {
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }

    fun fetchWeatherData() {
        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
                "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"
        val executor = Executors.newScheduledThreadPool(4)
        doAsync {
            Request(url).run()
            uiThread {
                longToast("Requests performed")
            }
        }
    }
}
