package com.github.emilg1101.spacex.data.repository.mapper

import com.github.emilg1101.spacex.data.spacexapi.pojo.response.LaunchPad
import com.github.emilg1101.spacex.domain.entity.Launch

typealias LaunchEntity = com.github.emilg1101.spacex.data.spacexapi.pojo.response.Launch

object LaunchMapper {

    fun map(entity: LaunchEntity): Launch {
        return Launch().apply {
            flightNumber = entity.flightNumber
            missionName = entity.missionName
            launchDate = entity.launchDateLocal
            patch = entity.links.missionPatch
        }
    }

    fun map(launchEntity: LaunchEntity, launchPad: LaunchPad): Launch {
        return Launch().apply {
            flightNumber = launchEntity.flightNumber
            missionName = launchEntity.missionName
            launchDate = launchEntity.launchDateLocal
            patch = launchEntity.links.missionPatch
            upcoming = launchEntity.upcoming
            rocketId = launchEntity.rocket.rocketId
            rocketName = launchEntity.rocket.rocketName
            details = launchEntity.details
            cores = launchEntity.rocket.firstStage.cores.map { core ->
                core.coreSerial?.let {
                    Launch.Core(it, core.landingVehicle, core.landingType, core.landSuccess, core.reused)
                }
            }.filterNotNull()
            payloads = launchEntity.rocket.secondStage.payloads.map { it.payloadId }
            images = launchEntity.links.flickrImages
            redditCampaign = launchEntity.links.redditCampaign
            redditLaunch = launchEntity.links.redditLaunch
            redditMedia = launchEntity.links.redditMedia
            redditRecovery = launchEntity.links.redditRecovery
            presskit = launchEntity.links.presskit
            articleLink = launchEntity.links.articleLink
            wikipedia = launchEntity.links.wikipedia
            videoLink = launchEntity.links.videoLink
            siteName = launchPad.location.name
            siteLatitude = launchPad.location.latitude
            siteLongitude = launchPad.location.longitude
        }
    }
}