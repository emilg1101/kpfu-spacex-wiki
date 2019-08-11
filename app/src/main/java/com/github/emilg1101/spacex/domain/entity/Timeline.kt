package com.github.emilg1101.spacex.domain.entity

import java.util.*

class Timeline {

    var events: List<HistoricalEvent> = listOf()

    class HistoricalEvent(
        val title: String,
        val eventDate: Date,
        val flightNumber: Int?,
        val details: String,
        val reddit: String?,
        val article: String?,
        val wikipedia: String?
    )
}
