package apod.julesssss.github.apod.network

import apod.julesssss.github.apod.data.model.ApiPhoto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * ApiService used to retrieve Astronomy photo of the day data
 */
interface NasaApodApi {

    @GET("planetary/apod")
    fun getPhotoOfTheDay(
        @Query("api_key") apiKey: String
    ): Single<ApiPhoto>

    @GET("planetary/apod")
    fun getPhotoForDate(
        @Query("date") date: String,
        @Query("api_key") apiKey: String
    ): Single<ApiPhoto>

}