package apod.julesssss.github.apod.ui.photolist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.data.model.ApiPhoto
import apod.julesssss.github.apod.data.model.ApodType
import apod.julesssss.github.apod.extension.loadWithPicasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.listitem_apod.*

/*
 * ViewHolder for APOD photos list item. Implements LayoutContainer for synthetic view caching behaviour.
 */
class ApodViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(photo: ApiPhoto) {
        listitemApodTextTitle.text = photo.title
        listitemApodTextDate.text = photo.date

        if (photo.apodType == ApodType.IMAGE) listitemApodImageMain.loadWithPicasso(
            photo.imageUrl,
            R.drawable.placeholder_black_hole
        )

        listitemApodImageTypeIcon.setImageResource(photo.apodType.iconDrawableRes)
    }
}