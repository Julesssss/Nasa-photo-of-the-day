package apod.julesssss.github.apod.ui.photodetail.imagegallery

import android.app.Application
import androidx.lifecycle.MutableLiveData
import apod.julesssss.github.apod.data.repo.ApodRepository
import apod.julesssss.github.apod.ui.base.DisposingViewModel
import io.reactivex.rxkotlin.subscribeBy
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class ImageViewModel(app: Application) : DisposingViewModel(app), KoinComponent {

    private val apodRepo: ApodRepository by inject()

    val viewState = MutableLiveData<ImageViewState>().also { it.value = ImageViewState() }

    fun setDesiredDate(apodDate: String) {
        add(apodRepo.getPhotoForDate(apodDate)
            .subscribeBy(
                onSuccess = {
                    viewState.value = viewState.value?.copy(textTitle = it.title, imageUrl = it.imageUrl)
                },
                onError = {}
            )
        )
    }
}