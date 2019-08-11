package com.github.emilg1101.spacex.domain.entity

class Mission {
    var name: String = ""
    var id: String = ""
    var manufacturers: List<String> = listOf()
    var payloads: List<String> = listOf()
    var wikipedia: String? = null
    var website: String? = null
    var twitter: String? = null
    var description: String? = null
}
