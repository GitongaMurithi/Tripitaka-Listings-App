package com.example.listingsapp_tripitaca.domain.repository

import com.example.listingsapp_tripitaca.data.dto.ListingsDto
import com.example.listingsapp_tripitaca.data.dto1.ListingDetailsDto

interface ListingsRepository {
//    fun getListings() : List<ListingsDto>
    fun getListItemById(itemId : String) : List<ListingsDto>?
}