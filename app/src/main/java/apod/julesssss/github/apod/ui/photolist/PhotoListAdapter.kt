package apod.julesssss.github.apod.ui.photolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.data.model.ApiPhoto

/*
 * Adapter for APOD photos list page
 */
class PhotoListAdapter(val clickCallback: (ApiPhoto) -> Unit) : RecyclerView.Adapter<ApodViewHolder>() {

    var apodPhotos = listOf<ApiPhoto>()
        set(value) {
            if (value != field) {
                field = value
                notifyDataSetChanged()
            }
        }

    override fun getItemCount(): Int = apodPhotos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodViewHolder =
        ApodViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.listitem_apod, parent, false))

    override fun onBindViewHolder(holder: ApodViewHolder, position: Int) {
        holder.bind(apodPhotos[position])
        holder.containerView.setOnClickListener {
            clickCallback(apodPhotos[position])
        }
    }
}