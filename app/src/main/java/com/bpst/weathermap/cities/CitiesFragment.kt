package com.bpst.weathermap.cities

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bpst.weathermap.R
import com.bpst.weathermap.model.cities
import com.bpst.weathermap.weather.WeatherFragment
import com.bpst.weathermap.weather.WeatherViewModel
import kotlinx.android.synthetic.main.cities_fragment.*


class CitiesFragment : Fragment() {

    companion object {
        fun newInstance() = CitiesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cities_fragment, container, false)
    }

    private val adapter = CityAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_cities.layoutManager = LinearLayoutManager(context)
        rv_cities.adapter = adapter
        adapter.items = cities
        adapter.setOnClick {city ->
            activity?.let {activity ->
               ViewModelProviders.of(activity)[WeatherViewModel::class.java].city.postValue(city.id)
                goToWeather()
            }
        }
    }

    private fun goToWeather(){
        fragmentManager?.beginTransaction()
            ?.addToBackStack("weather")
            ?.replace(R.id.container, WeatherFragment.newInstance())
            ?.commit()
    }


}
