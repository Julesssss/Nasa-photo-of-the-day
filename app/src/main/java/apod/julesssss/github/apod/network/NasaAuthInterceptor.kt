package apod.julesssss.github.apod.network

import apod.julesssss.github.apod.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response


/**
 * Interceptor is used to attach NASA API authentication query to each request.
 */
class NasaAuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url()

        val modifiedUrl = originalHttpUrl.newBuilder()
            .addQueryParameter(API_HEADER, BuildConfig.NASA_API_KEY)
            .build()

        val newRequest = originalRequest.newBuilder().url(modifiedUrl)
        return chain.proceed(newRequest.build())
    }
}