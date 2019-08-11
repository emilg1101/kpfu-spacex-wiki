package com.github.emilg1101.spacex.domain.entity

import java.util.*

class Core {
    var serial: String = ""
    var block: String? = null
    var status: String = ""
    var launch: Date? = null
    var missions: List<Mission> = listOf()
    var details: String? = null
    var reuseCount: Int = 0
    var waterLanding: Boolean = false
    var rtlsAttempts: Int = 0
    var rtlsLandings: Int = 0
    var asdsAttempts: Int = 0
    var asdsLandings: Int = 0

    class Mission(val name: String, val flightNumber: Int)
}
