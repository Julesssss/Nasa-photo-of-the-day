package apod.julesssss.github.apod.ui.photodetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.ui.photodetail.imagegallery.ImagePagerAdapter
import apod.julesssss.github.apod.ui.photolist.PhotoSelection
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

        setupFromArguments()
    }

    private fun setupFromArguments() {
        intent.getParcelableExtra<PhotoSelection>(apodSelectionKey)?.let {
            supportActionBar?.title = it.apiPhoto.title
            photoDetailViewPager.currentItem = it.position
        }
    }

    private fun updateState(state: PhotoDetailViewModel.ViewState) {
        // TODO
    }
}
