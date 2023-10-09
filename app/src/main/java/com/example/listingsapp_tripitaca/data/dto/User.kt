package com.example.listingsapp_tripitaca.data.dto


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("address")
    val address: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("coverPictureURL")
    val coverPictureURL: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("favouriteFoods")
    val favouriteFoods: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("following")
    val following: Int,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("hasPassword")
    val hasPassword: Boolean,
    @SerializedName("hasPaymentMethod")
    val hasPaymentMethod: Boolean,
    @SerializedName("_id")
    val id: String,
//    @SerializedName("interests")
//    val interests: List<Any>,
    @SerializedName("isBusinessOwner")
    val isBusinessOwner: Boolean,
    @SerializedName("isFollowing")
    val isFollowing: Boolean,
    @SerializedName("isPackageDue")
    val isPackageDue: Boolean,
    @SerializedName("isPhoneNumberVerified")
    val isPhoneNumberVerified: Boolean,
    @SerializedName("isProfileIncomplete")
    val isProfileIncomplete: Boolean,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("noOfRates")
    val noOfRates: Int,
    @SerializedName("package")
    val packageX: String,
    @SerializedName("profilePictureURL")
    val profilePictureURL: String,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("referralCode")
    val referralCode: String,
    @SerializedName("reviews")
    val reviews: Int,
    @SerializedName("timeStamp")
    val timeStamp: Long,
    @SerializedName("type")
    val type: String,
    @SerializedName("__v")
    val v: Int
)