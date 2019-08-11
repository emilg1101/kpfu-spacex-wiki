package com.github.emilg1101.spacex.domain.entity

import java.util.*

class Launch {

    var flightNumber: Int = 0
    var missionName: String = ""
    var launchDate: Date = Date()
    var patch: String? = null
    var upcoming: Boolean = false
    var rocketId: String = ""
    var rocketName: String = ""
    var details: String? = null
    var cores: List<Core> = listOf()
    var payloads: List<String> = listOf()
    var images: List<String> = listOf()
    var redditCampaign: String? = null
    var redditLaunch: String? = null
    var redditRecovery: String? = null
    var redditMedia: String? = null
    var presskit: String? = null
    var articleLink: String? = null
    var wikipedia: String? = null
    var videoLink: String? = null
    var siteName: String = ""
    var siteLatitude: Double = 0.0
    var siteLongitude: Double = 0.0

    class Core(
        val serial: String,
        val landingVehicle: String?,
        val landingType: String?,
        val landingSuccessful: Boolean?,
        val reused: Boolean
    )
}