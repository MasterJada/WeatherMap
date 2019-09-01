package com.bpst.weathermap.model


data class WeatherModel(val id: Int, val main: String, val description: String) {
    override fun toString(): String {
        return StringBuilder().append(main)
            .append(System.getProperty("line.separator"))
            .append(description)
            .toString()
    }
}

data class MainModel(
    val temp: Float,
    val pressure: Int,
    val humidity: Float,
    val temp_min: Float,
    val temp_max: Float
) {
    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("Temperature: $temp")
        builder.append(System.getProperty("line.separator"))
        builder.append("Pressure: $pressure")
        builder.append(System.getProperty("line.separator"))
        builder.append("Humidity: $humidity")
        builder.append(System.getProperty("line.separator"))
        builder.append("Max temperature: $temp_max")
        builder.append(System.getProperty("line.separator"))
        builder.append("Min temperature: $temp_min")
        return builder.toString()
    }
}

data class ResponseModel(
    val main: MainModel,
    val weather: ArrayList<WeatherModel>,
    val name: String,
    val id: Int
) {
    fun getWeatherString(): String {
        val builder = StringBuilder()
        weather.forEach {
            builder.append(it.toString())
        }
        return builder.toString()
    }

    fun getMainString() = main.toString()
}