package apod.julesssss.github.apod.ui.photolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import apod.julesssss.github.apod.R
import apod.julesssss.github.apod.extension.findViewModel
import apod.julesssss.github.apod.extension.toast

class PhotoListActivity : AppCompatActivity() {

    private lateinit var viewModel: PhotoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        // Find reference to ViewModel and subscribe to lifecycle events
        viewModel = findViewModel()
        lifecycle.addObserver(viewModel)

        // subscribe to ViewModel state
        viewModel.state.observe(this, Observer { updateState(it) })
    }

    private fun updateState(state: PhotoListViewModel.ViewState) {
        toast(state.data.toString())
    }
}
