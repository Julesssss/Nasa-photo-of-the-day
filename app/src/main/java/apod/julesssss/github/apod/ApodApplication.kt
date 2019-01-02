package apod.julesssss.github.apod

import android.app.Application
import apod.julesssss.github.apod.di.appModule
import org.koin.android.ext.android.startKoin

class ApodApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }

}