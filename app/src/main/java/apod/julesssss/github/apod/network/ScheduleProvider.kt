package apod.julesssss.github.apod.network

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Holds Schedulers for use in Rx chains. Use this object with .compose() in the chain.
 */
object ScheduleProvider {

    private val backgroundScheduler: Scheduler = Schedulers.io()
    private val foregroundScheduler: Scheduler = AndroidSchedulers.mainThread()

    /**
     * Set foreground / background schedulers on Singles
     */
    fun <T> getSchedulersForSingle(): (Single<T>) -> Single<T> {
        return {
            it.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }

}