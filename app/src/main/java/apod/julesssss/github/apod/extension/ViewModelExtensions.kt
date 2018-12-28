package apod.julesssss.github.apod.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import apod.julesssss.github.apod.ApodApplication

/*
 * Simplify ViewModel lookup from Activity
 */
inline fun <reified T : ViewModel> AppCompatActivity.findViewModel(): T =
    ViewModelProviders.of(this).get(T::class.java)

/*
 * Simplify access to application from ViewModels
 */
fun AndroidViewModel.app(): ApodApplication = getApplication()