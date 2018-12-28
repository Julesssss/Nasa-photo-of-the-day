package apod.julesssss.github.apod.data.repo

import apod.julesssss.github.apod.data.model.ApiPhoto
import apod.julesssss.github.apod.network.NasaApodApi
import apod.julesssss.github.apod.network.ScheduleProvider
import io.reactivex.Single
import io.reactivex.functions.Function3

class ApodRepository(private val nasaApodApi: NasaApodApi) {

    /*
     * Retrieve today's astronomy photo of the day
     */
    private fun getPhotoOfTheDay(): Single<ApiPhoto> = nasaApodApi.getPhotoOfTheDay()
        .compose(ScheduleProvider.getSchedulersForSingle())

    /*
     * Retrieve astronomy photo for a specific date
     */
    private fun getPhotoForDate(): Single<ApiPhoto> = nasaApodApi.getPhotoForDate("2018-12-20")
        .compose(ScheduleProvider.getSchedulersForSingle())

    /*
     * Retrieve the last 7 days of photos
     */
    fun getMultiple(): Single<List<ApiPhoto>> = Single.zip(
        getPhotoOfTheDay(),
        getPhotoForDate(),
        getPhotoForDate(),
        Function3<ApiPhoto, ApiPhoto, ApiPhoto, List<ApiPhoto>> { todaysPhoto, yesterdaysPhoto, photo3 ->
            listOf(todaysPhoto, yesterdaysPhoto, photo3)
        }
    )
}