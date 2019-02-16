package apod.julesssss.github.apod.ui.photodetail.imagegallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.data.repo.ApodRepository
import apod.julesssss.github.apod.extension.loadWithPicasso
import kotlinx.android.synthetic.main.item_apod_image.*
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ARG_APOD_DATE = "APOD_DATE"

/**
 * Fragment to display a fullscreen gallery image with a caption and progress indication
 */
class ImageFragment : Fragment(), KoinComponent {

    private val viewModel: ImageViewModel by viewModel()
    private val apodRepo: ApodRepository by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_apod_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // load APOD from DB or Network (choice delegated to Repo)
        viewModel.retrieveApod() // todo NEXT

        // display image and other info
        itemApodImage.loadWithPicasso(arguments.getApodDate(), R.drawable.placeholder_black_hole)

        // todo: load from repo..... if exists, else
    }

    private fun Bundle?.getApodDate() = this?.getString(ARG_APOD_DATE) ?: ""

    companion object {

        fun newInstance(apodDate: String): ImageFragment {
            return ImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_APOD_DATE, apodDate)
                }
            }
        }
    }
}
