package com.bpst.weathermap

import com.bpst.weathermap.model.MainModel
import com.bpst.weathermap.model.ResponseModel
import com.bpst.weathermap.model.WeatherModel
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        val weather = WeatherModel(0, "Main", "Description")
        val mainModel = MainModel(2.0F, 2, 2.0F, 2.0F, 3.0F)

        val responseModel = ResponseModel(mainModel, arrayListOf(weather), "Test", 9000)

        assertEquals("Main\nDescription", weather.toString())
        assertEquals("Temperature: 2.0\n" +
                "Pressure: 2\n" +
                "Humidity: 2.0\n" +
                "Max temperature: 3.0\n" +
                "Min temperature: 2.0",responseModel.main.toString())
    }
}
