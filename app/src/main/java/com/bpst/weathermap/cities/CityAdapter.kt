package com.bpst.weathermap.cities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bpst.weathermap.model.CityModel

class CityAdapter: RecyclerView.Adapter<CityAdapter.CityVH>() {
    var items: ArrayList<CityModel> = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    private var  onClick: ((CityModel) -> Unit)? = null

    fun setOnClick(click: (CityModel) -> Unit){
        onClick = click
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityVH {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_expandable_list_item_1,
            parent, false)

        return CityVH(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CityVH, position: Int) {
       items[position].let {city ->
           holder.text.text = city.name
           holder.itemView.setOnClickListener {
               onClick?.invoke(city)
           }
       }
    }


    class CityVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(android.R.id.text1)
    }
}