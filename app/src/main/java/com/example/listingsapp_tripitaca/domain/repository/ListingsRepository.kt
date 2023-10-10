package com.example.listingsapp_tripitaca.domain.repository

import com.example.listingsapp_tripitaca.data.dto.ListingsDto

interface ListingsRepository {
//    fun getListings() : List<ListingsDto>
    fun getListItemById(itemId : String) : List<ListingsDto>?
}