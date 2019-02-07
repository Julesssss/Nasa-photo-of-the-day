package apod.julesssss.github.apod.ui.photodetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.data.model.ApiPhoto
import apod.julesssss.github.apod.extension.debugToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotoDetailActivity : AppCompatActivity() {

    private val viewModel: PhotoDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)

        lifecycle.addObserver(viewModel)

        // subscribe to ViewModel state
        viewModel.state.observe(this, Observer { updateState(it) })

        // check for bundled APOD. if it exists, display
        intent.getParcelableExtra<ApiPhoto>(apiPhotoKey)?.let { displayPhoto(it) }
            ?: debugToast("APOD not attached to bundle!")
    }

    private fun displayPhoto(apiPhoto: ApiPhoto) {
        supportActionBar?.title = apiPhoto.title
    }

    private fun updateState(state: PhotoDetailViewModel.ViewState) {

    }
}
