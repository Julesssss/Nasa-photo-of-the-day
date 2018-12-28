package apod.julesssss.github.apod.ui.photolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import apod.julesssss.github.apod.ApodApplication
import apod.julesssss.github.apod.data.repo.ApodRepository
import io.reactivex.Single

class PhotoListViewModel(app: Application) : AndroidViewModel(app), LifecycleObserver {

    private val chartRepo: ApodRepository = (app as ApodApplication).apodRepository

    fun getPhotoList(): Single<List<String>> = chartRepo.getPhotoOfTheDay().map {
        listOf(
            it.imageUrl,
            it.imageUrl,
            it.imageUrl,
            it.imageUrl
        )
    }
}