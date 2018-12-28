package apod.julesssss.github.apod.data.model

import com.google.gson.annotations.SerializedName

data class ApiPhoto(
    val date: String = "",
    val title: String = "",
    val explanation: String = "",
    val copyright: String = "",
    @SerializedName("hdurl") val hdImageUrl: String = "",
    @SerializedName("url") val imageUrl: String = "",
    @SerializedName("media_type") val mediaType: String = "",
    @SerializedName("service_version") val serviceVersion: String = ""
)