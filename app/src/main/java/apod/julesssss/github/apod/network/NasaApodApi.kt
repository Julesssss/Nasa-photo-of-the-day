package apod.julesssss.github.apod.network

import apod.julesssss.github.apod.data.model.ApiPhoto
import io.reactivex.Single
import retrofit2.http.GET

/**
 * ApiService used to retrieve Astronomy photo of the day data
 */
interface NasaApodApi {

    @GET("planetary/apod?api_key=DEMO_KEY")
    fun getPhotoOfTheDay(): Single<ApiPhoto>

}