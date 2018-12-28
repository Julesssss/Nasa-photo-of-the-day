package apod.julesssss.github.apod.ui.photolist

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import apod.julesssss.github.apod.ApodApplication
import apod.julesssss.github.apod.data.model.ApiPhoto
import apod.julesssss.github.apod.data.repo.ApodRepository
import apod.julesssss.github.apod.ui.base.DisposingViewModel
import io.reactivex.rxkotlin.subscribeBy

class PhotoListViewModel(app: Application) : DisposingViewModel(app), LifecycleObserver {

    /*
     * Represents the state of ViewModel, all necessary info should be contained within this data class.
     */
    data class ViewState(
        val data: List<ApiPhoto> = listOf(),
        val isLoading: Boolean = true
    )

    private val chartRepo: ApodRepository = (app as ApodApplication).apodRepository

    val state = MutableLiveData<ViewState>().also { it.value = ViewState() }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getPhotoList() {
        add(chartRepo.getPhotoOfTheDay().subscribeBy(
            onSuccess = { onPhotosRetrieved(it) },
            onError = { it.printStackTrace() }
        ))
    }

    private fun onPhotosRetrieved(data: ApiPhoto) {
        state.value = state.value?.copy(
            isLoading = false,
            data = listOf(data, data, data)
        )
    }

}