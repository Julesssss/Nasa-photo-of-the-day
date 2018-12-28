package apod.julesssss.github.apod.network

import apod.julesssss.github.apod.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Provide networking service. TODO: should be handled by dependency manager.
 */
object ServiceProvider {

    fun buildNasaApodApi(): NasaApodApi =
        Retrofit.Builder()
            .baseUrl(BuildConfig.NASA_API_URL)
            .client(buildOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NasaApodApi::class.java)

    private fun buildOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .cache(null)
            .addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(NasaAuthInterceptor())
            .build()
}