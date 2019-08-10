package com.github.emilg1101.spacex.data.repository

import com.github.emilg1101.spacex.data.repository.mapper.LaunchMapper
import com.github.emilg1101.spacex.data.spacexapi.request.SpaceXApiRequest
import com.github.emilg1101.spacex.domain.entity.Launch
import com.github.emilg1101.spacex.domain.repository.LaunchesRepository
import io.reactivex.Single
import javax.inject.Inject

class LaunchesRepositoryImpl @Inject constructor(): LaunchesRepository {

    @field:Inject
    lateinit var api: SpaceXApiRequest

    override fun getLaunch(flightNumber: Int): Single<Launch> {
        TODO("not implement")
    }

    override fun getUpcomingLaunches(): Single<List<Launch>> {
        return api.getUpcomingLaunches()
            .toObservable()
            .flatMapIterable { list -> list }
            .map(LaunchMapper::map)
            .toList()
    }

    override fun getPastLaunches(): Single<List<Launch>> {
        return api.getPastLaunches()
            .toObservable()
            .flatMapIterable { list -> list }
            .map(LaunchMapper::map)
            .toList()
    }
}