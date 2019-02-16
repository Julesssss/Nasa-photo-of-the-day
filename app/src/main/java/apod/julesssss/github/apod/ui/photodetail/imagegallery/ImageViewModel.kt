package apod.julesssss.github.apod.ui.photodetail.imagegallery

import android.app.Application
import androidx.lifecycle.MutableLiveData
import apod.julesssss.github.apod.data.model.ApiPhoto
import apod.julesssss.github.apod.ui.base.DisposingViewModel
import org.koin.standalone.KoinComponent

class ImageViewModel(app: Application) : DisposingViewModel(app), KoinComponent {

    fun retrieveApod() {
//        TODO("Return APOD from either Network or DB")
    }

    /*
     * Represents the state of ViewModel.
     */
    data class ViewState(
        val data: ApiPhoto = ApiPhoto()
    )

    val state = MutableLiveData<ViewState>().also { it.value = ViewState() }

}