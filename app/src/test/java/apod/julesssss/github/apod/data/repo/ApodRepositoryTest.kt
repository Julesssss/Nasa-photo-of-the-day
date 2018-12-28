package apod.julesssss.github.apod.data.repo

import apod.julesssss.github.apod.network.NasaApodApi
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class ApodRepositoryTest {

    private lateinit var apodRepository: ApodRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        apodRepository = ApodRepository(Mockito.mock(NasaApodApi::class.java))
    }

    @Test
    fun `test that last 7 day formats are built correctly from date`() {
        val date = Date().also { it.time = 1546012330053 }

        val dates = apodRepository.buildWeekArrayFromDate(date)
        assertEquals(dates[0], "2018-12-28")
        assertEquals(dates[1], "2018-12-27")
        assertEquals(dates[2], "2018-12-26")
        assertEquals(dates[3], "2018-12-25")
        assertEquals(dates[4], "2018-12-24")
        assertEquals(dates[5], "2018-12-23")
        assertEquals(dates[6], "2018-12-22")

    }
}