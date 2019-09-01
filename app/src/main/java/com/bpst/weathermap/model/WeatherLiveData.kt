package com.bpst.weathermap.model

import androidx.lifecycle.LiveData
import io.reactivex.disposables.CompositeDisposable

class WeatherLiveData(private val cityId: Int): LiveData<ResponseModel>() {
    private val disposables = CompositeDisposable()

    override fun onActive() {
        super.onActive()
        WeatherApi.getClient().weatherForCityId(cityId)
            .subscribe({
                postValue(it)
            },{
                print("")
            })
    }

    override fun onInactive() {
        super.onInactive()
        disposables.dispose()
    }
}