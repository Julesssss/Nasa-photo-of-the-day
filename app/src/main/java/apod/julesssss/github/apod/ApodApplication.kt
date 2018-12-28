package apod.julesssss.github.apod

import android.app.Application
import apod.julesssss.github.apod.data.repo.ApodRepository
import apod.julesssss.github.apod.network.NasaApodApi
import apod.julesssss.github.apod.network.ServiceProvider

class ApodApplication : Application() {

    // todo: application class is temporarily used to handle singleton access to API & repository. Replace with dependency injection solution

    private val apodApi: NasaApodApi by lazy { ServiceProvider.buildNasaApodApi() }

    internal val apodRepository: ApodRepository by lazy { ApodRepository(apodApi) }

}