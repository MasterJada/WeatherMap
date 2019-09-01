package com.bpst.weathermap.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bpst.weathermap.R
import com.bpst.weathermap.databinding.WeatherFragmentBinding


class WeatherFragment : Fragment() {

    companion object {
        fun newInstance() = WeatherFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: WeatherFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false)
        val viewModel = ViewModelProviders.of(activity!!)[WeatherViewModel::class.java]
        binding.data = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}
