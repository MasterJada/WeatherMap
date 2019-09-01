package com.bpst.weathermap.model


data class WeatherModel(val id: Int, val main: String, val description: String)
data class MainModel(val temp: Float, val pressure: Int, val humidity: Float, val temp_min: Float,  val temp_max: Float)

data class ResponseModel(val main: MainModel, val weather: WeatherModel, val name: String, val id: Int)