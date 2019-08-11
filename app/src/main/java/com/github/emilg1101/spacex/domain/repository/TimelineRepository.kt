package com.github.emilg1101.spacex.domain.repository

import com.github.emilg1101.spacex.domain.entity.Timeline
import io.reactivex.Single

interface TimelineRepository {

    fun getTimeline(): Single<Timeline>
}
