package com.github.emilg1101.spacex.data.repository

import com.github.emilg1101.spacex.data.repository.mapper.TimelineMapper
import com.github.emilg1101.spacex.data.spacexapi.request.SpaceXApiRequest
import com.github.emilg1101.spacex.domain.entity.Timeline
import com.github.emilg1101.spacex.domain.repository.TimelineRepository
import io.reactivex.Single
import javax.inject.Inject

class TimelineRepositoryImpl @Inject constructor() : TimelineRepository {

    @field:Inject
    lateinit var api: SpaceXApiRequest

    override fun getTimeline(): Single<Timeline> {
        return api.getAllHistoricalEvents()
            .map(TimelineMapper::map)
    }
}
