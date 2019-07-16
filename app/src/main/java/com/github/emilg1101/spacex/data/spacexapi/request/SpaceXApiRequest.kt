package com.github.emilg1101.spacex.data.spacexapi.request

import com.github.emilg1101.spacex.data.spacexapi.pojo.response.HistoricalEvent
import io.reactivex.Single
import retrofit2.http.GET

interface SpaceXApiRequest {

    @GET("history")
    fun getAllHistoricalEvents(): Single<List<HistoricalEvent>>
}
