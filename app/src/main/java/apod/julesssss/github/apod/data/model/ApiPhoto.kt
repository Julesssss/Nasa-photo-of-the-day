package apod.julesssss.github.apod.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * An APOD which can be of type image or video.
 */
@Parcelize
data class ApiPhoto(
    val date: String = "",
    val title: String = "",
    val explanation: String = "",
    val copyright: String? = "",
    @SerializedName("hdurl") val hdImageUrl: String = "",
    @SerializedName("url") val imageUrl: String = "",
    @SerializedName("media_type") val mediaType: String = "",
    @SerializedName("service_version") val serviceVersion: String = ""
) : Parcelable {

    val apodType: ApodType
        get() = when (mediaType) {
            "video" -> ApodType.VIDEO
            else -> ApodType.IMAGE
        }

}