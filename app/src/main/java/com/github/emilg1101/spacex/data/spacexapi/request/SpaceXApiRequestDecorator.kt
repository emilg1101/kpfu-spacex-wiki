package com.github.emilg1101.spacex.data.spacexapi.request

import com.github.emilg1101.spacex.data.spacexapi.pojo.response.*
import com.github.emilg1101.spacex.domain.exception.ApiUnavailableException
import com.github.emilg1101.spacex.domain.exception.InternetConnectionException
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class SpaceXApiRequestDecorator(private val api: SpaceXApiRequest) : SpaceXApiRequest {

    companion object {
        private fun processApiThrowable(t: Throwable): Throwable {
            return when (t) {
                is UnknownHostException, is SocketTimeoutException -> InternetConnectionException()
                is HttpException -> ApiUnavailableException()
                else -> t
            }
        }
    }

    private class SpaceXApiRequestErrorSingleTransformer<T> : SingleTransformer<T, T> {
        override fun apply(upstream: Single<T>): SingleSource<T> {
            return upstream.onErrorResumeNext { t: Throwable ->
                Single.error(processApiThrowable(t))
            }
        }
    }

    override fun getAllHistoricalEvents(): Single<List<HistoricalEvent>> {
        return api.getAllHistoricalEvents().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getCompanyInfo(): Single<CompanyInfo> {
        return api.getCompanyInfo().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getUpcomingLaunches(): Single<List<Launch>> {
        return api.getUpcomingLaunches().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getPastLaunches(): Single<List<Launch>> {
        return api.getPastLaunches().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getAllCapsules(): Single<List<Capsule>> {
        return api.getAllCapsules().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getAllCores(): Single<List<Core>> {
        return api.getAllCores().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getAllDragons(): Single<List<Dragon>> {
        return api.getAllDragons().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getAllLandingPads(): Single<List<LandingPad>> {
        return api.getAllLandingPads().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getAllLaunchPads(): Single<List<LaunchPad>> {
        return api.getAllLaunchPads().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getAllMissions(): Single<List<Mission>> {
        return api.getAllMissions().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getAllPayloads(): Single<List<Payload>> {
        return api.getAllPayloads().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getAllRockets(): Single<List<Rocket>> {
        return api.getAllRockets().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getRoadster(): Single<Roadster> {
        return api.getRoadster().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getAllShips(): Single<List<Ship>> {
        return api.getAllShips().compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getLaunchPadById(siteId: String): Single<LaunchPad> {
        return api.getLaunchPadById(siteId).compose(SpaceXApiRequestErrorSingleTransformer())
    }

    override fun getLaunch(flightNumber: Int): Single<Launch> {
        return api.getLaunch(flightNumber).compose(SpaceXApiRequestErrorSingleTransformer())
    }
}
