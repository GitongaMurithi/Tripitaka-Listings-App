package com.example.listingsapp_tripitaca

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listingsapp_tripitaca.data.dto.ListingsDto

class AmenitiesAdapter (
    private val items : List<ListingsDto>,
    val context: Context
) : RecyclerView.Adapter<AmenitiesAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val amenity : TextView = itemView.findViewById(R.id.amenities_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.amenities_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProperty = items[position]
        currentProperty.amenities.forEach { amenity ->
            holder.amenity.text = amenity
        }
    }
}