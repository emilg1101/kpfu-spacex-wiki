package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("mission_patch") val missionPatch: String?,
    @SerializedName("mission_patch_small") val missionPatchSmall: String?,
    @SerializedName("reddit_campaign") val redditCampaign: String?,
    @SerializedName("reddit_launch") val redditLaunch: String?,
    @SerializedName("reddit_recovery") val redditRecovery: String?,
    @SerializedName("reddit_media") val redditMedia: String?,
    @SerializedName("presskit") val presskit: String?,
    @SerializedName("article_link") val articleLink: String?,
    @SerializedName("wikipedia") val wikipedia: String?,
    @SerializedName("video_link") val videoLink: String?,
    @SerializedName("youtube_id") val youtubeId: String?,
    @SerializedName("flickr_images") val flickrImages: List<String>,
    @SerializedName("article") val article: String?,
    @SerializedName("reddit") val reddit: String?
)
