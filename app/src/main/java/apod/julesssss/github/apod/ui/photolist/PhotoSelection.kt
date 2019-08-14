package apod.julesssss.github.apod.ui.photolist

import android.os.Parcelable
import apod.julesssss.github.apod.data.model.ApiPhoto
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoSelection(
    val position: Int,
    val apiPhoto: ApiPhoto
) : Parcelable