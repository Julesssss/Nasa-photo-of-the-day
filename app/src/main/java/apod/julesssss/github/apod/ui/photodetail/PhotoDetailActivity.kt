package apod.julesssss.github.apod.ui.photodetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.data.model.ApiPhoto
import apod.julesssss.github.apod.extension.debugToast
import apod.julesssss.github.apod.ui.photodetail.imagegallery.ImagePagerAdapter
import kotlinx.android.synthetic.main.activity_photo_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Activity which displays a full screen APOD. User can swipe left and right to view additional APODs.
 */
class PhotoDetailActivity : AppCompatActivity() {

    private val viewModel: PhotoDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)

        // setup ViewPager
        photoDetailViewPager.adapter = ImagePagerAdapter(supportFragmentManager)

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
