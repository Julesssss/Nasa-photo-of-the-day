package apod.julesssss.github.apod.extension

import android.content.Context
import android.util.Log
import android.widget.Toast
import apod.julesssss.github.apod.BuildConfig

fun Context.toast(message: String?) {
    if (!message.isNullOrEmpty()) Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.debugToast(message: String?) {
    if (BuildConfig.DEBUG && !message.isNullOrEmpty()) toast(message)
}

fun Any.log(message: String?) {
    if (BuildConfig.DEBUG && !message.isNullOrEmpty()) Log.i(this::class.java.simpleName, message)
}