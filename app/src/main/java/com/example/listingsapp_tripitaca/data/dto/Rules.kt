package com.example.listingsapp_tripitaca.data.dto


import com.google.gson.annotations.SerializedName

data class Rules(
    @SerializedName("checkIn")
    val checkIn: String,
    @SerializedName("checkOut")
    val checkOut: String,
    @SerializedName("rules")
    val rules: List<Any>
)