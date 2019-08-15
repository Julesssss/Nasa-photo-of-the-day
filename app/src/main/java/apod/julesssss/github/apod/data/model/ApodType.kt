package apod.julesssss.github.apod.data.model

import androidx.annotation.DrawableRes
import apod.julesssss.github.apod.R

sealed class ApodType(@DrawableRes val iconDrawableRes: Int) {
    object IMAGE : ApodType(R.drawable.ic_image)
    object VIDEO : ApodType(R.drawable.ic_movie)
}