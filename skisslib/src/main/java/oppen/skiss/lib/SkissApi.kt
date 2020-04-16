package oppen.skiss.lib

import android.graphics.Color
import android.util.Log
import kotlin.random.Random

fun random(start: Number, end: Number): Float{
    return Random.nextLong(start.toLong(), end.toLong()).toFloat()
}

fun random(number: Number): Float{
    if(number.toFloat() <= 0) return 0F
    return Random.nextLong(0L, number.toLong()).toFloat()
}

fun color(color: String): Int{
    return Color.parseColor(color)
}

fun map(value: Float, start1: Float, stop1: Float, start2: Float, stop2: Float): Float{
    return start2 + (stop2 - start2) * ((value - start1) / (stop1 - start1))
}

//This is an extremely naive implementation
fun lerpColor(startColor: Int, endColor: Int, amount: Float): Int{
    val sR = Color.red(startColor)
    val sG = Color.green(startColor)
    val sB = Color.blue(startColor)

    val eR = Color.red(endColor)
    val eG = Color.green(endColor)
    val eB = Color.blue(endColor)

    val r = lerp(sR.toFloat(), eR.toFloat(), amount)
    val g = lerp(sG.toFloat(), eG.toFloat(), amount)
    val b = lerp(sB.toFloat(), eB.toFloat(), amount)
    return rgbColour(r.toInt(), g.toInt(), b.toInt())
}

private fun lerp(start: Float, end: Float, amount: Float): Float {
    return start * (1-amount) + end * amount
}

fun rgbColour(r: Int, g: Int, b: Int): Int {
    val red = r shl 16 and 0x00FF0000
    val green = g shl 8 and 0x0000FF00
    val blue = b and 0x000000FF
    return -0x1000000 or red or green or blue
}

fun l(message: String){
    Log.d("SKISS", message)
}

fun e(message: String){
    Log.e("SKISS", message)
}

