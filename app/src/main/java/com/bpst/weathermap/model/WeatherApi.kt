package com.bpst.weathermap.model

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    val appkey: String
        get() = "b6907d289e10d714a6e88b30761fae22"

    @GET
    fun weatherForCityId(@Query("id") cityID: Int,
                         @Query("appid") key: String = appkey): Observable<ResponseModel>


    companion object{
        fun getClient() = Retrofit.Builder()
            .baseUrl("https://openweathermap.org/data/2.5/weather")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create<WeatherApi>()
    }
}