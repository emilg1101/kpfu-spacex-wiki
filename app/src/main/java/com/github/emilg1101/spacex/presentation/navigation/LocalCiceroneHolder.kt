package com.github.emilg1101.spacex.presentation.navigation

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import java.lang.Exception

object LocalCiceroneHolder {

    private var containers = HashMap<String, Cicerone<Router>>()

    fun getCicerone(containerTag: String): Cicerone<Router> {
        if (!containers.containsKey(containerTag)) {
            containers[containerTag] = Cicerone.create()
        }
        return containers[containerTag] ?: Cicerone.create()
    }
}
