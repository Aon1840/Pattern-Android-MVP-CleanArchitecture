package com.coin.data.model

import com.google.gson.annotations.SerializedName

data class MobileEntity(
        @SerializedName("brand") var brand: String? = null,
        @SerializedName("thumbImageURL") var thumbImageURL: String? = null,
        @SerializedName("price") var price: String? = null,
        @SerializedName("name") var name: String? = null,
        @SerializedName("rating") var rating: String? = null,
        @SerializedName("id") var id: Int? = null,
        @SerializedName("description") var description: String? = null
)
