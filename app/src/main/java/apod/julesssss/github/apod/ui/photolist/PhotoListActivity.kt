package apod.julesssss.github.apod.ui.photolist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.extension.createLinearLayoutManager
import apod.julesssss.github.apod.extension.findViewModel
import kotlinx.android.synthetic.main.activity_photo_list.*

class PhotoListActivity : AppCompatActivity() {

    private lateinit var viewModel: PhotoListViewModel

    private var adapter: PhotoListAdapter = PhotoListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        photoListRecyclerView.createLinearLayoutManager()
        photoListRecyclerView.adapter = adapter

        // Find reference to ViewModel and subscribe to lifecycle events
        viewModel = findViewModel()
        lifecycle.addObserver(viewModel)

        // subscribe to ViewModel state
        viewModel.state.observe(this, Observer { updateState(it) })
    }

    private fun updateState(state: PhotoListViewModel.ViewState) {
        adapter.apodPhotos = state.data
        photoListProgressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE
        photoListTextError.text = state.errorMessage
    }
}
