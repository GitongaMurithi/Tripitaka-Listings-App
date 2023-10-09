package com.example.listingsapp_tripitaca

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listingsapp_tripitaca.data.dto.ListingsDto
import javax.inject.Inject

class ListingsAdapter @Inject constructor(
    private val context: Context,
    private var items: List<ListingsDto>
) : RecyclerView.Adapter<ListingsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.item)
        val bathrooms: TextView = itemView.findViewById(R.id.bathValue)
        val bedrooms: TextView = itemView.findViewById(R.id.brValue)
        val beds: TextView = itemView.findViewById(R.id.bedsVAlue)
        val guests: TextView = itemView.findViewById(R.id.guestsValue)
        val price: TextView = itemView.findViewById(R.id.amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listing_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bathrooms.text = currentItem.details.bath.toString()
        holder.bedrooms.text = currentItem.details.bedroom.toString()
        holder.beds.text = currentItem.details.beds.toString()
        holder.guests.text = currentItem.details.guests.toString()
        holder.price.text = currentItem.price.amount.toString()

        val url = currentItem.photos[1]
        Glide.with(context).load(url).into(holder.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ListingsDetails::class.java)
            intent.putExtra("property_id", currentItem.id)
            context.startActivity(intent)
        }
    }

    fun filterByLocation(location : String) {

    val filteredItems = if (location.isEmpty()) {
            items

        } else {
            items.filter { property ->
                Log.d("ErrorCheck", property.location.name)
                property.location.name.contains(location , ignoreCase  = true)
            }
        }
        val mutableItems = mutableListOf<ListingsDto>()
        mutableItems.addAll(filteredItems)

        // Update the RecyclerView adapter with the new mutableItems
        items = mutableItems
        notifyDataSetChanged()
    }
}