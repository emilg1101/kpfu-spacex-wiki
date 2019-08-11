package com.github.emilg1101.spacex.data.repository.mapper

import com.github.emilg1101.spacex.data.spacexapi.pojo.response.HistoricalEvent
import com.github.emilg1101.spacex.domain.entity.Timeline

object TimelineMapper {

    fun map(historicalEvents: List<HistoricalEvent>): Timeline {
        return Timeline().apply {
            events = historicalEvents.map {
                Timeline.HistoricalEvent(
                    it.title,
                    it.eventDateUtc,
                    it.flightNumber,
                    it.details,
                    it.links.reddit,
                    it.links.article,
                    it.links.wikipedia
                )
            }
        }
    }
}
