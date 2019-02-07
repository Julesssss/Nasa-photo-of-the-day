package apod.julesssss.github.apod.ui.photodetail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import apod.julesssss.github.apod.data.model.ApiPhoto
import apod.julesssss.github.apod.ui.base.DisposingViewModel
import org.koin.standalone.KoinComponent

class PhotoDetailViewModel(app: Application) : DisposingViewModel(app), KoinComponent {

    /*
     * Represents the state of ViewModel.
     */
    data class ViewState(
        val data: ApiPhoto = ApiPhoto()
    )

    val state = MutableLiveData<ViewState>().also { it.value = ViewState() }

}