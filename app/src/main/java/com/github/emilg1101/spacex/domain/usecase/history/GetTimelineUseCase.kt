package com.github.emilg1101.spacex.domain.usecase.history

import com.github.emilg1101.spacex.domain.entity.Timeline
import com.github.emilg1101.spacex.domain.repository.TimelineRepository
import io.reactivex.Single
import javax.inject.Inject

class GetTimelineUseCase @Inject constructor() {

    @field:Inject
    lateinit var timelineRepository: TimelineRepository

    fun getTimeline(): Single<Timeline> {
        return timelineRepository.getTimeline()
    }
}
