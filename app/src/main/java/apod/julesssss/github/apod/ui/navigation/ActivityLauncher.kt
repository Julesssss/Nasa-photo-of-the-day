package apod.julesssss.github.apod.ui.navigation

import android.app.Activity
import android.content.Intent
import apod.julesssss.github.apod.data.model.ApiPhoto
import apod.julesssss.github.apod.ui.photodetail.PhotoDetailActivity
import apod.julesssss.github.apod.ui.photodetail.apiPhotoKey

object ActivityLauncher {

    fun launchDetailActivity(activity: Activity, apiPhoto: ApiPhoto) {
        activity.startActivity(Intent(activity, PhotoDetailActivity::class.java).apply {
            putExtra(apiPhotoKey, apiPhoto)
        })
    }

}