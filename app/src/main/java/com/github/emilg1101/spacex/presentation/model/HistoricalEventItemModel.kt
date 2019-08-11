package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Timeline
import com.github.emilg1101.spacex.presentation.util.format

class HistoricalEventItemModel(
    val title: String,
    val details: String,
    val date: String,
    val reddit: String,
    val article: String,
    val wikipedia: String,
    val flightNumber: Int
)

object HistoricalEventItemModelMapper {

    fun map(timeline: Timeline): List<HistoricalEventItemModel> {
        return timeline.events.map { event ->
            HistoricalEventItemModel(
                event.title,
                event.details,
                event.eventDate.format("yyyy-mm-dd"),
                event.reddit ?: "",
                event.article ?: "",
                event.wikipedia ?: "",
                event.flightNumber ?: 0
            )
        }
    }
}
