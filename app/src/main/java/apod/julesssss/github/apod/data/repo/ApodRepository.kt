package apod.julesssss.github.apod.data.repo

import apod.julesssss.github.apod.data.model.ApiPhoto
import apod.julesssss.github.apod.network.NasaApodApi
import apod.julesssss.github.apod.network.ScheduleProvider
import io.reactivex.Single

class ApodRepository(private val nasaApodApi: NasaApodApi) {

    /*
     * Retrieve today's astronomy photo of the day
     */
    fun getPhotoOfTheDay(): Single<ApiPhoto> = nasaApodApi.getPhotoOfTheDay()
        .compose(ScheduleProvider.getSchedulersForSingle())

}