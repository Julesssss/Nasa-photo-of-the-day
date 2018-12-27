package apod.julesssss.github.apod.ui.photolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import apod.julesssss.github.apod.R
import kotlinx.android.synthetic.main.activity_photo_list.*

class PhotoListActivity : AppCompatActivity() {

    private val viewModel by lazy { PhotoListViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        photoListTextTemp.text = viewModel.getPhotoList().toString()
    }
}
