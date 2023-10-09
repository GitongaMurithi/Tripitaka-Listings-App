package com.example.listingsapp_tripitaca.data.dto


import com.google.gson.annotations.SerializedName

data class Details(
    @SerializedName("bath")
    val bath: Int,
    @SerializedName("bedroom")
    val bedroom: Int,
    @SerializedName("beds")
    val beds: Int,
    @SerializedName("guests")
    val guests: Int
)