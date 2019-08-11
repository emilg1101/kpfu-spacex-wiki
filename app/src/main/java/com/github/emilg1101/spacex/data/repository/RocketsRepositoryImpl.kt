package com.github.emilg1101.spacex.data.repository

import com.github.emilg1101.spacex.data.repository.mapper.RocketMapper
import com.github.emilg1101.spacex.data.spacexapi.request.SpaceXApiRequest
import com.github.emilg1101.spacex.domain.entity.Rocket
import com.github.emilg1101.spacex.domain.repository.RocketsRepository
import io.reactivex.Single
import javax.inject.Inject

class RocketsRepositoryImpl @Inject constructor() : RocketsRepository {

    @field:Inject
    lateinit var api: SpaceXApiRequest

    override fun getRocket(id: String): Single<Rocket> {
        TODO("not implemented")
    }

    override fun getRockets(): Single<List<Rocket>> {
        return api.getAllRockets()
            .toObservable()
            .flatMapIterable { list -> list }
            .map(RocketMapper::map)
            .toList()
    }
}
