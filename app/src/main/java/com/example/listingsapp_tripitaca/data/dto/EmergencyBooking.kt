package com.example.listingsapp_tripitaca.data.dto


import com.google.gson.annotations.SerializedName

data class EmergencyBooking(
    @SerializedName("bookable")
    val bookable: Boolean,
    @SerializedName("discountPercentage")
    val discountPercentage: Int,
    @SerializedName("selfCheckin")
    val selfCheckin: Boolean
)