package com.bpst.weathermap.model

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
   private val appkey: String
        get() = "b6907d289e10d714a6e88b30761fae22"

    @GET("weather")
    fun weatherForCityId(@Query("id") cityID: Int,
                         @Query("appid") key: String = appkey): Observable<ResponseModel>


    companion object{
        fun getClient() = Retrofit.Builder()
            .baseUrl("https://openweathermap.org/data/2.5/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create<WeatherApi>()
    }
}