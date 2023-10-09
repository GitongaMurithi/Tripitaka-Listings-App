package com.example.listingsapp_tripitaca.data.dto


import com.google.gson.annotations.SerializedName

data class ListingsDto(
    @SerializedName("amenities")
    val amenities: List<String>,
    @SerializedName("bookedDates")
    val bookedDates: List<String>,
    @SerializedName("bookings")
    val bookings: Int,
    @SerializedName("cancellationPolicy")
    val cancellationPolicy: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("details")
    val details: Details,
    @SerializedName("emergencyBooking")
    val emergencyBooking: EmergencyBooking,
    @SerializedName("_id")
    val id: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("noOfRates")
    val noOfRates: Int,
    @SerializedName("photos")
    val photos: List<String>,
    @SerializedName("point")
    val point: Point,
    @SerializedName("price")
    val price: Price,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("recommendations")
    val recommendations: Int,
//    @SerializedName("reviews")
//    val reviews: List<Any>,
    @SerializedName("rules")
    val rules: Rules,
    @SerializedName("space")
    val space: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("timeStamp")
    val timeStamp: Long,
    @SerializedName("type")
    val type: String,
    @SerializedName("uniqueType")
    val uniqueType: String,
    @SerializedName("user")
    val user: User,
    @SerializedName("__v")
    val v: Int
)