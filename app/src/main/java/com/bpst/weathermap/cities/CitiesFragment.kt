package com.bpst.weathermap.cities

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bpst.weathermap.R

class CitiesFragment : Fragment() {

    companion object {
        fun newInstance() = CitiesFragment()
    }

    private lateinit var viewModel: CitiesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cities_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CitiesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
