package apod.julesssss.github.apod.data.model

import com.google.gson.annotations.SerializedName

/*
 * An APOD which can be of type image or video.
 */
data class ApiPhoto(
    val date: String = "",
    val title: String = "",
    val explanation: String = "",
    val copyright: String? = "",
    @SerializedName("hdurl") val hdImageUrl: String = "",
    @SerializedName("url") val imageUrl: String = "",
    @SerializedName("media_type") val mediaType: String = "",
    @SerializedName("service_version") val serviceVersion: String = ""
)

enum class ApodType {
    IMAGE,
    VIDEO
}

/*
 * Returns the ApodType of content
 */
fun ApiPhoto.getType(): ApodType = when (mediaType) {
    "video" -> ApodType.VIDEO
    else -> ApodType.IMAGE
}