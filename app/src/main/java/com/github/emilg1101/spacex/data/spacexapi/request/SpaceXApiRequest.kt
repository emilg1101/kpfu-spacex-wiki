package com.github.emilg1101.spacex.data.spacexapi.request

import com.github.emilg1101.spacex.data.spacexapi.pojo.response.Capsule
import com.github.emilg1101.spacex.data.spacexapi.pojo.response.CompanyInfo
import com.github.emilg1101.spacex.data.spacexapi.pojo.response.HistoricalEvent
import com.github.emilg1101.spacex.data.spacexapi.pojo.response.Launch
import io.reactivex.Single
import retrofit2.http.GET

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
}
