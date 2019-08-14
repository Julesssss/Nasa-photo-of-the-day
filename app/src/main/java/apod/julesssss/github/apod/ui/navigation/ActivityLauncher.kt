package apod.julesssss.github.apod.ui.navigation

import android.app.Activity
import android.content.Intent
import apod.julesssss.github.apod.ui.photodetail.PhotoDetailActivity
import apod.julesssss.github.apod.ui.photodetail.apodSelectionKey
import apod.julesssss.github.apod.ui.photolist.PhotoSelection

object ActivityLauncher {

    fun launchDetailActivity(activity: Activity, selection: PhotoSelection) {
        activity.startActivity(Intent(activity, PhotoDetailActivity::class.java).apply {
            putExtra(apodSelectionKey, selection)
        })
    }
}