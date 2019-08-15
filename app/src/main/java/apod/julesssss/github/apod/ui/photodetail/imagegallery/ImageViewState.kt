package apod.julesssss.github.apod.ui.photodetail.imagegallery

/*
 * Represents the state of ViewModel.
 */
data class ImageViewState(
    val textTitle: String = "",
    val imageUrl: String = "",
    val imageLoading: Boolean = true,
    val isError: Boolean = false
)