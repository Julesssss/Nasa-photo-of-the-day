package apod.julesssss.github.apod.ui.photolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.data.model.ApiPhoto
import apod.julesssss.github.apod.extension.loadWithPicasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.listitem_apod.view.*

class PhotoListAdapter : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    var apodPhotos = listOf<ApiPhoto>()
        set(value) {
            if (value != field) {
                field = value
                notifyDataSetChanged()
            }
        }

    override fun getItemCount(): Int = apodPhotos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.listitem_apod, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(apodPhotos[position])
    }

    /*
     * ViewHolder for ApiPhoto. Implements LayoutContainer for synthetic view caching behaviour.
     */
    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(photo: ApiPhoto) {
            with(containerView) {
                listitemApodTextTitle.text = photo.title
                listitemApodImageMain.loadWithPicasso(photo.imageUrl, R.drawable.ic_error)
            }
        }
    }
}