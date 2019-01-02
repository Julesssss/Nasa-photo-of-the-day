package apod.julesssss.github.apod.ui.photolist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.extension.createLinearLayoutManager
import kotlinx.android.synthetic.main.activity_photo_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotoListActivity : AppCompatActivity() {

    private val viewModel: PhotoListViewModel by viewModel()

    private var adapter: PhotoListAdapter = PhotoListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        photoListRecyclerView.createLinearLayoutManager()
        photoListRecyclerView.adapter = adapter

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
