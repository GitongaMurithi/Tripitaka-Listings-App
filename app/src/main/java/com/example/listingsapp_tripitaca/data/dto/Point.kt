package com.example.listingsapp_tripitaca.data.dto


import com.google.gson.annotations.SerializedName

data class Point(
    @SerializedName("coordinates")
    val coordinates: List<Double>,
    @SerializedName("type")
    val type: String
)