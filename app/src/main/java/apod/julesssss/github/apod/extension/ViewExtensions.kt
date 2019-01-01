package apod.julesssss.github.apod.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

/**
 * Simply the creation of LinearLayoutManagers. Default is Vertical, but can be changed.
 */
fun RecyclerView.createLinearLayoutManager(
    orientation: Int = RecyclerView.VERTICAL,
    reverseLayout: Boolean = false
) {
    layoutManager = LinearLayoutManager(context, orientation, reverseLayout)
}

/*
 * Helper for loading images with Picasso
 */
fun ImageView.loadWithPicasso(imageUrl: String, @DrawableRes fallbackDrawableId: Int) =
    Picasso.get()
        .load(imageUrl)
        .error(fallbackDrawableId)
        .into(this)