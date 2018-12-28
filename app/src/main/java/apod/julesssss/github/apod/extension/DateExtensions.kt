package apod.julesssss.github.apod.extension

import apod.julesssss.github.apod.util.DateConstants
import java.text.SimpleDateFormat
import java.util.*

class DateExtensions {

    fun Date.formatToDay(): String {
        return SimpleDateFormat(DateConstants.dayFormat, Locale.getDefault()).format(this)
    }

}