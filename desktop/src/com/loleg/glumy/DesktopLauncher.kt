package com.loleg.glumy

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

fun main() {
    val config = Lwjgl3ApplicationConfiguration()
    config.setForegroundFPS(60)
    config.setTitle("Glumy")
    config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode())
    Lwjgl3Application(Glumy(), config)
}
