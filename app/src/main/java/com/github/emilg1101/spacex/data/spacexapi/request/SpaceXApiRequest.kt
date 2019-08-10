package com.github.emilg1101.spacex.data.spacexapi.request

import com.github.emilg1101.spacex.data.spacexapi.pojo.response.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXApiRequest {

    @GET("history")
    fun getAllHistoricalEvents(): Single<List<HistoricalEvent>>

    @GET("info")
    fun getCompanyInfo(): Single<CompanyInfo>

    @GET("launches/upcoming")
    fun getUpcomingLaunches(): Single<List<Launch>>

    @GET("launches/past")
    fun getPastLaunches(): Single<List<Launch>>

    @GET("capsules")
    fun getAllCapsules(): Single<List<Capsule>>

    @GET("cores")
    fun getAllCores(): Single<List<Core>>

    @GET("dragons")
    fun getAllDragons(): Single<List<Dragon>>

    @GET("landpads")
    fun getAllLandingPads(): Single<List<LandingPad>>

    @GET("launchpads")
    fun getAllLaunchPads(): Single<List<LaunchPad>>

    @GET("missions")
    fun getAllMissions(): Single<List<Mission>>

    @GET("payloads")
    fun getAllPayloads(): Single<List<Payload>>

    @GET("rockets")
    fun getAllRockets(): Single<List<Rocket>>

    @GET("roadster")
    fun getRoadster(): Single<Roadster>

    @GET("ships")
    fun getAllShips(): Single<List<Ship>>

    @GET("launchpads/{site_id}")
    fun getLaunchPadById(@Path("site_id") siteId: String): Single<LaunchPad>
}
