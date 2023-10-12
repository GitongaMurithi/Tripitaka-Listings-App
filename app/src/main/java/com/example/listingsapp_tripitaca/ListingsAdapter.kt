package com.example.listingsapp_tripitaca

import android.content.Context
import android.content.Intent
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
    private var context: Context,
    private var properties: List<ListingsDto>
) : RecyclerView.Adapter<ListingsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.item)
        val bathrooms: TextView = itemView.findViewById(R.id.bathValue)
        val bedrooms: TextView = itemView.findViewById(R.id.brValue)
        val beds: TextView = itemView.findViewById(R.id.bedsVAlue)
        val guests: TextView = itemView.findViewById(R.id.guestsValue)
        val price: TextView = itemView.findViewById(R.id.amount)
        val loc : TextView = itemView.findViewById(R.id.locationElemnt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listing_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return properties.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProperty = properties[position]
        holder.bathrooms.text = currentProperty.details.bath.toString()
        holder.bedrooms.text = currentProperty.details.bedroom.toString()
        holder.beds.text = currentProperty.details.beds.toString()
        holder.guests.text = currentProperty.details.guests.toString()
        holder.price.text = currentProperty.price.amount.toString()
        holder.loc.text = currentProperty.location.name

        val url = currentProperty.photos[3]
        Glide.with(context).load(url).into(holder.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ListingsDetails::class.java)
            intent.putExtra("property_id", currentProperty.id)
            context.startActivity(intent)
        }
    }

}