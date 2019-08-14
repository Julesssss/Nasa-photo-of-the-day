package apod.julesssss.github.apod.ui.photodetail.imagegallery

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import apod.julesssss.github.apod.util.ApodDate
import org.koin.standalone.KoinComponent

/*
 * Totally scrollable limit to ViewPager. Currently limited, but should be expanded dynamically as user scrolls
 */
const val apodLimit = 20 // todo: remove hardcoded value

class ImagePagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT), KoinComponent {

    override fun getItem(position: Int): Fragment {
        val dateString = ApodDate.getDateFromPosition(position)
        return ImageFragment.newInstance(dateString)
    }

    override fun getCount() = apodLimit

}
