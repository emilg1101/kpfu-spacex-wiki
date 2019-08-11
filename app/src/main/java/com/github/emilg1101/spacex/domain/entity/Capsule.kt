package com.github.emilg1101.spacex.domain.entity

import java.util.*

class Capsule {
    var serial: String = ""
    var id: String = ""
    var status: String = ""
    var launch: Date? = null
    var missions: List<Mission> = listOf()
    var landings: Int = 0
    var type: String = ""
    var details: String? = null
    var reuse: Int = 0

    class Mission(val name: String, val flightNumber: Int)
}
