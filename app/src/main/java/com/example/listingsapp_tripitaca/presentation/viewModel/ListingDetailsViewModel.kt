package com.example.listingsapp_tripitaca.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.listingsapp_tripitaca.data.dto.ListingsDto
import com.example.listingsapp_tripitaca.domain.repository.ListingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListingDetailsViewModel @Inject constructor(
    private val repository: ListingsRepository
) : ViewModel(){

    fun listings() : List<ListingsDto> {
        return repository.getAllItems()
    }
    fun getListingItemById(itemId : String) : ListingsDto? {
        val properties = listings()
        return properties.find { it.id == itemId }
    }
}