package apod.julesssss.github.apod.data.repo

import apod.julesssss.github.apod.BuildConfig
import apod.julesssss.github.apod.data.model.ApiPhoto
import apod.julesssss.github.apod.network.NasaApodApi
import apod.julesssss.github.apod.network.ScheduleProvider
import apod.julesssss.github.apod.util.DateConstants
import apod.julesssss.github.apod.util.DateConstants.dayInMillis
import io.reactivex.Single
import io.reactivex.functions.Function7
import java.text.SimpleDateFormat
import java.util.*

class ApodRepository(private val nasaApodApi: NasaApodApi) {

    /*
     * Retrieve today's astronomy photo of the day
     */
    private fun getPhotoOfTheDay(): Single<ApiPhoto> = nasaApodApi.getPhotoOfTheDay(BuildConfig.NASA_API_KEY)
        .compose(ScheduleProvider.getSchedulersForSingle())

    /*
     * Retrieve astronomy photo for a specific date
     */
    fun getPhotoForDate(date: String): Single<ApiPhoto> = nasaApodApi.getPhotoForDate(date, BuildConfig.NASA_API_KEY)
        .compose(ScheduleProvider.getSchedulersForSingle())

    /*
     * Retrieve the last 7 astronomy photos of the day
     */
    fun getLast7Photos(): Single<List<ApiPhoto>> {
        val lastWeekDates = buildWeekArrayFromDate(Date())

        return Single.zip(
            getPhotoForDate(lastWeekDates[0]),
            getPhotoForDate(lastWeekDates[1]),
            getPhotoForDate(lastWeekDates[2]),
            getPhotoForDate(lastWeekDates[3]),
            getPhotoForDate(lastWeekDates[4]),
            getPhotoForDate(lastWeekDates[5]),
            getPhotoForDate(lastWeekDates[6]),

            Function7<ApiPhoto, ApiPhoto, ApiPhoto, ApiPhoto, ApiPhoto, ApiPhoto, ApiPhoto, List<ApiPhoto>> { p0, p1, p2, p3, p4, p5, p6 ->
                listOf(p0, p1, p2, p3, p4, p5, p6).filter { it.imageUrl.isNotEmpty() }
            }
        )
    }

    /*
     * Create an array of formatted dates which will be used to retrieve specific APODs
     */
    internal fun buildWeekArrayFromDate(date: Date): List<String> {
        val dateArray = mutableListOf<String>()

        for (i in 1..7) {
            dateArray.add(SimpleDateFormat(DateConstants.dayFormat, Locale.getDefault()).format(date))
            date.time = date.time - dayInMillis
        }

        return dateArray
    }
}