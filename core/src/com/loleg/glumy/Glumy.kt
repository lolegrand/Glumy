package com.loleg.glumy

import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen

class Glumy : Game() {


    override fun create() {
        screen = GlumyMainScreen(this)
    }
}

abstract class GlumyScreen(val game: Game) : Screen {

    override fun show() { }

    override fun render(delta: Float) { }

    override fun resize(width: Int, height: Int) { }

    override fun pause() { }

    override fun resume() { }

    override fun hide() { }

    override fun dispose() { }

}
