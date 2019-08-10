package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Launch
import com.yandex.mapkit.geometry.Point
import java.text.SimpleDateFormat

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
    val rocketName: String
)

object LaunchModelMapper {
    fun map(launch: Launch): LaunchModel {
        val format = SimpleDateFormat("dd MM`yy-hh:mm")
        return LaunchModel(
            launch.flightNumber,
            launch.missionName,
            launch.patch ?: "",
            format.format(launch.launchDate),
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
            launch.rocketName
        )
    }
}
