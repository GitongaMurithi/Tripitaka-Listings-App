package com.example.listingsapp_tripitaca.data.repository

import android.content.Context
import com.example.listingsapp_tripitaca.data.dto.ListingsDto
import com.example.listingsapp_tripitaca.domain.repository.ListingsRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ListingsRepositoryImpl @Inject constructor(
    private val context: Context
) : ListingsRepository {
//    override fun getListings(): List<ListingsDto> {
//        return getListingsData.getListings()
//    }


    override fun getAllItems(): List<ListingsDto> {
        val jsonContents = readJsonContents(context)
        val gson = Gson()
        val listType = object : TypeToken<List<ListingsDto>>() {}.type
        return gson.fromJson(jsonContents, listType)
    }


    private fun readJsonContents(context: Context): String? {
        return try {
            val inputStream = context.assets.open("listings.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            String(buffer, Charsets.UTF_8)
        } catch (exception: Exception) {
            exception.printStackTrace()
            null
        }
    }

}