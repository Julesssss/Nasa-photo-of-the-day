package apod.julesssss.github.apod.util

import apod.julesssss.github.apod.extension.formatToDay
import java.util.*

/**
 * Helper class for date related functionality which is too general for an extension.
 */
object ApodDate {

    /**
     * Returns a formatted date string depending on position. This is used by service to retrieve specific APOD's.
     *
     * @param position: represents the index of photos of the day. Today = 0, Yesterday - 1, ect
     */
    fun getDateFromPosition(position: Int): String {
        val calendar = Calendar.getInstance()
        val dayOfYear = calendar.get(Calendar.DAY_OF_YEAR)
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear - position)

        return calendar.time?.formatToDay() ?: ""
    }

}