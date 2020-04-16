package oppen.skiss.lib

import android.graphics.Canvas
import android.graphics.Paint

abstract class SkissSyntaxBase {

    class SkissPaint(var active: Boolean = false): Paint()

    private val fillPaint = SkissPaint().apply {
        style = Paint.Style.FILL
    }
    private val strokePaint = SkissPaint().apply {
        style = Paint.Style.STROKE
    }

    var width = -1
    var height = -1

    var canvas: Canvas? = null

    fun background(color: Int){
        canvas?.drawColor(color)
    }

    fun stroke(color: String){
        strokePaint.color = color(color)
        strokePaint.active = true
    }

    fun stroke(color: Int){
        strokePaint.color = color
        strokePaint.active = true
    }

    fun fill(color: String){
        fillPaint.color = color(color)
        fillPaint.active = true
    }

    fun fill(color: Int){
        fillPaint.color = color
        fillPaint.active = true
    }

    fun noFill(){
        fillPaint.active = false
    }
    fun noStroke(){
        strokePaint.active = false
    }
    fun line(x1: Number, y1: Number, x2: Number, y2: Number){
        if(strokePaint.active) canvas?.drawLine(x1.toFloat(), y1.toFloat(),x2.toFloat(), y2.toFloat(), strokePaint)
    }
    fun circle(x: Number, y: Number, radius: Number){
        if(strokePaint.active) canvas?.drawCircle(x.toFloat(), y.toFloat(), radius.toFloat(), strokePaint)
        if(fillPaint.active) canvas?.drawCircle(x.toFloat(), y.toFloat(), radius.toFloat(), fillPaint)
    }
}