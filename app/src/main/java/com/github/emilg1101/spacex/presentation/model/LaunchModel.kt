package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Launch
import com.github.emilg1101.spacex.presentation.util.format
import com.yandex.mapkit.geometry.Point

class LaunchModel(
    val flightNumber: Int,
    val missionName: String,
    val missionPatch: String,
    val launchTime: String,
    val launchPadId: String,
    val launchPadName: String,
    val launchPadCoords: Point,
    val details: String,
    val cores: List<CoreLaunchItemModel>,
    val payloads: List<PayloadLaunchItemModel>,
    val links: List<LinkLaunchItemModel>,
    val images: List<String>,
    val rocketId: String,
    val rocketName: String,
    val upcoming: Boolean
)

object LaunchModelMapper {
    fun map(launch: Launch): LaunchModel {
        return LaunchModel(
            launch.flightNumber,
            launch.missionName,
            launch.patch ?: "",
            launch.launchDate.format(),
            "",
            launch.siteName,
            Point(launch.siteLatitude, launch.siteLongitude),
            launch.details ?: "",
            launch.cores.map(CoreLaunchItemModelMapper::map),
            launch.payloads.map(PayloadLaunchItemModelMapper::map),
            listOfNotNull(
                launch.redditCampaign?.let {
                    LinkLaunchItemModel("Reddit", it)
                },
                launch.redditLaunch?.let {
                    LinkLaunchItemModel("Reddit Launch", it)
                },
                launch.redditRecovery?.let {
                    LinkLaunchItemModel("Reddit Recovery", it)
                },
                launch.redditMedia?.let {
                    LinkLaunchItemModel("Reddit Media", it)
                },
                launch.presskit?.let {
                    LinkLaunchItemModel("Presskit", it)
                },
                launch.articleLink?.let {
                    LinkLaunchItemModel("Article", it)
                },
                launch.wikipedia?.let {
                    LinkLaunchItemModel("wikipedia", it)
                },
                launch.videoLink?.let {
                    LinkLaunchItemModel("youtube", it)
                }
            ),
            launch.images,
            launch.rocketId,
            launch.rocketName,
            launch.upcoming
        )
    }
}
