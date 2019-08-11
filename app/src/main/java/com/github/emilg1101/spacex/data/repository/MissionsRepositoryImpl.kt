package com.github.emilg1101.spacex.data.repository

import com.github.emilg1101.spacex.data.repository.mapper.MissionMapper
import com.github.emilg1101.spacex.data.spacexapi.request.SpaceXApiRequest
import com.github.emilg1101.spacex.domain.entity.Mission
import com.github.emilg1101.spacex.domain.repository.MissionsRepository
import io.reactivex.Single
import javax.inject.Inject

class MissionsRepositoryImpl @Inject constructor(): MissionsRepository {

    @field:Inject
    lateinit var api: SpaceXApiRequest

    override fun getMissionById(id: String): Single<Mission> {
        TODO("not implemented")
    }

    override fun getMissions(): Single<List<Mission>> {
        return api.getAllMissions()
            .toObservable()
            .flatMapIterable { list -> list }
            .map(MissionMapper::map)
            .toList()
    }
}