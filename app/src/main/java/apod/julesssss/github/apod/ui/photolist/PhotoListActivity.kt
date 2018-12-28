package apod.julesssss.github.apod.ui.photolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.extension.findViewModel
import apod.julesssss.github.apod.extension.toast
import io.reactivex.rxkotlin.subscribeBy

class PhotoListActivity : AppCompatActivity() {

    private lateinit var viewModel: PhotoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        // Find reference to ViewModel and subscribe to lifecycle events
        viewModel = findViewModel()
        lifecycle.addObserver(viewModel)

        // todo: this is temporary, networking should be handled by VM, which simply passes view state to Activity.
        viewModel.getPhotoList().subscribeBy(
            onSuccess = { toast("list: $it") },
            onError = { it.printStackTrace() }
        )
    }
}
