package oppen.skiss.lib.objects

import oppen.skiss.lib.random
import kotlin.math.sqrt

data class Vektor(var x: Float, var y: Float) {

    constructor(x: Number, y: Number) : this(x.toFloat(), y.toFloat())
    constructor(coord: Coord) : this(coord.x, coord.y)

    companion object{
        fun dot(v1: Vektor, v2: Vektor): Float {
            return v1.x * v2.x + v1.y * v2.y
        }

        fun randomDirection(): Vektor {
            val direction = Vektor(
                random(
                    -1f,
                    1f
                ), random(-1f, 1f)
            )
            direction.normalise()
            return direction
        }

        fun randomPosition(width: Number, height: Number): Vektor {
            return Vektor(
                random(
                    0f,
                    width
                ), random(0f, height)
            )
        }

        fun direction(start: Vektor, end: Vektor): Vektor {
            return Vektor(
                end.x - start.x,
                end.y - start.y
            )
        }

        fun normal(vectorA: Vektor, vectorB: Vektor): Vektor {
            val delta = vectorA - vectorB
            delta.normalize()
            return Vektor(-delta.y, delta.x)
        }

        fun empty(): Vektor {
            return Vektor(0, 0)
        }
    }


    fun reset(){
        x = 0f
        y = 0f
    }
    fun magnitude(): Float{
        return sqrt(x * x + y * y)
    }

    fun normalise(){
        val magnitude = magnitude()
        if(magnitude > 0){
            this.x = x/magnitude
            this.y = y/magnitude
        }
    }

    fun distance(other: Vektor): Float{
        val dx = x - other.x
        val dy = y - other.y
        return sqrt(dx * dx + dy * dy)
    }

    fun direction(other: Vektor): Vektor {
        val direction = Vektor(other.x - x, other.y - y)
        direction.normalise()
        return direction
    }

    fun dot(other: Vektor): Float {
        return x * other.x + y * other.y
    }

    fun perpendicular(): Vektor {
        val pX = -y
        val pY = x
        return Vektor(pX, pY)
    }

    fun normalize() = normalise()

    fun limit(max: Float){
        when {
            magnitudeSquared() > max * max -> {
                normalise()
                x *= max
                y *= max
            }
        }
    }

    fun magnitudeSquared(): Float {
        return x * x + y * y
    }

    fun coord(): Coord =
        Coord(x, y)

    operator fun plus(vector: Vektor): Vektor {
        return Vektor(
            this.x + vector.x,
            this.y + vector.y
        )
    }

    operator fun minus(vector: Vektor): Vektor {
        return Vektor(
            this.x - vector.x,
            this.y - vector.y
        )
    }

    operator fun times(value: Number): Vektor {
        return Vektor(
            this.x * value.toFloat(),
            this.y * value.toFloat()
        )
    }

    operator fun div(value: Number): Vektor {
        return Vektor(
            this.x / value.toFloat(),
            this.y / value.toFloat()
        )
    }

    fun clone(): Vektor {
        return Vektor(x, y)
    }
}