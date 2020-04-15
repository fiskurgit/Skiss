package oppen.skiss.example

import android.graphics.Canvas
import oppen.skiss.lib.Skiss
import oppen.skiss.lib.SkissView
import oppen.skiss.lib.color
import oppen.skiss.lib.random

class DemoSkiss(view: SkissView): Skiss(view) {

    private val background = color("#1d1d1d")
    private val red = color("#ff0000")
    private val pale = color("#55ffffff")
    private var y = 0f

    override fun setup(width: Int, height: Int) {}

    override fun update(canvas: Canvas) {
        background(background)

        y += 2
        if (y > height) y = 0f

        stroke(red)
        line(0f, y, width.toFloat(), y)

        noStroke()
        fill(pale)
        repeat(100) {
            circle(random(width), random(height), random(5, 40))
        }
    }
}