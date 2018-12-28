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

const val DATE_28TH_DEC_2018_IN_MILLIS = 1546012330053

val WEEK_DATES_LEADING_TO_28TH_DEC_2018 = listOf(
    "2018-12-28", "2018-12-27", "2018-12-26", "2018-12-25", "2018-12-24", "2018-12-23", "2018-12-22"
)

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
        val date = Date().also { it.time = DATE_28TH_DEC_2018_IN_MILLIS }
        val dates = apodRepository.buildWeekArrayFromDate(date)

        // verify count
        assertEquals(dates.size, 7)

        // verify dates
        assertEquals(dates, WEEK_DATES_LEADING_TO_28TH_DEC_2018)
    }
}