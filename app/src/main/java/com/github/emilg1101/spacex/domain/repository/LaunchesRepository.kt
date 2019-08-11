package com.github.emilg1101.spacex.domain.repository

import com.github.emilg1101.spacex.domain.entity.Launch
import io.reactivex.Single

interface LaunchesRepository {

    fun getLaunch(flightNumber: Int): Single<Launch>

    fun getUpcomingLaunches(): Single<List<Launch>>

    fun getPastLaunches(): Single<List<Launch>>
}