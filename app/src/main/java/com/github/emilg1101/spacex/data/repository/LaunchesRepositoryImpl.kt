package com.github.emilg1101.spacex.data.repository

import com.github.emilg1101.spacex.data.repository.mapper.LaunchMapper
import com.github.emilg1101.spacex.data.spacexapi.pojo.response.LaunchPad
import com.github.emilg1101.spacex.data.spacexapi.request.SpaceXApiRequest
import com.github.emilg1101.spacex.domain.entity.Launch
import com.github.emilg1101.spacex.domain.repository.LaunchesRepository
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class LaunchesRepositoryImpl @Inject constructor() : LaunchesRepository {

    @field:Inject
    lateinit var api: SpaceXApiRequest

    override fun getLaunch(flightNumber: Int): Single<Launch> {
        return api.getLaunch(flightNumber)
            .flatMap {
                Single.zip(
                    Single.just(it),
                    api.getLaunchPadById(it.launchSite.siteId),
                    BiFunction<com.github.emilg1101.spacex.data.spacexapi.pojo.response.Launch, LaunchPad, Launch> { t1, t2 ->
                        LaunchMapper.map(t1, t2)
                    }
                )
            }
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