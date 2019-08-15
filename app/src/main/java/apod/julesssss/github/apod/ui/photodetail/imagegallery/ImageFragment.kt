package apod.julesssss.github.apod.ui.photodetail.imagegallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.extension.loadWithPicasso
import kotlinx.android.synthetic.main.item_apod_image.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.standalone.KoinComponent

private const val ARG_APOD_DATE = "APOD_DATE"

/**
 * Fragment to display a fullscreen gallery image with a caption and progress indication
 */
class ImageFragment : Fragment(), KoinComponent {

    private val viewModel: ImageViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_apod_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycle.addObserver(viewModel)
        viewModel.viewState.observe(viewLifecycleOwner, Observer { state -> updateViewState(state) })

        viewModel.setDesiredDate(arguments.getApodDate())
    }

    private fun updateViewState(state: ImageViewState) {
        itemApodImage.loadWithPicasso(state.imageUrl, R.drawable.placeholder_black_hole)
        itemApodTitle.text = state.textTitle
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
