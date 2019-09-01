package com.bpst.weathermap.weather


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.bpst.weathermap.model.ResponseModel
import com.bpst.weathermap.model.WeatherLiveData

class WeatherViewModel : ViewModel() {
    val city =  MutableLiveData<Int>()
    val weather: LiveData<ResponseModel> = Transformations.switchMap(city) {
        WeatherLiveData(it)
    }
}
