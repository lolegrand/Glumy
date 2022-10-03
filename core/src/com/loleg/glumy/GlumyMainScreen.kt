package com.loleg.glumy

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.Array

class GlumyMainScreen(game: Game) : GlumyScreen(game) {

    companion object {
        const val FRAME_COLS = 10
        const val FRAME_ROWS = 1
    }

    private val walkAnimation : Animation<TextureRegion>
    private val walkSheet = Texture(Gdx.files.internal("knight/_Run.png"))
    private val spriteBatch = SpriteBatch()
    private var stateTime = 0f

    init {
        val tmp = TextureRegion.split(
            walkSheet, walkSheet.width / FRAME_COLS, walkSheet.height / FRAME_ROWS
        )
        val walkFrame: Array<TextureRegion> = Array<TextureRegion>(FRAME_COLS * FRAME_ROWS)

        for ( i in 0 until FRAME_ROWS) {
            for (j in 0 until FRAME_COLS) {
                walkFrame.add(tmp[i][j])
            }
        }

        walkAnimation = Animation<TextureRegion>(0.025f, walkFrame)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.deltaTime
        val currentFrame = walkAnimation.getKeyFrame(stateTime, true)
        spriteBatch.begin()
        spriteBatch.draw(currentFrame, 50f, 50f)
        spriteBatch.end()
    }

    override fun dispose() {
        spriteBatch.dispose()
        walkSheet.dispose()
    }
}