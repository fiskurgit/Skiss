package oppen.skiss.lib

import android.graphics.Canvas
import android.graphics.Paint

abstract class SkissSyntaxBase {

    private val fillPaint = Paint()
    private val strokePaint = Paint()

    init {
        fillPaint.style = Paint.Style.FILL
        strokePaint.style = Paint.Style.STROKE
    }

    var doFill = false
    var doStroke = false

    var width = -1
    var height = -1

    var canvas: Canvas? = null

    fun background(color: Int){
        canvas?.drawColor(color)
    }

    fun stroke(color: String){
        strokePaint.color = color(color)
        doStroke = true
    }

    fun stroke(color: Int){
        strokePaint.color = color
        doStroke = true
    }

    fun fill(color: String){
        fillPaint.color = color(color)
        doFill = true
    }

    fun fill(color: Int){
        fillPaint.color = color
        doFill = true
    }

    fun noFill(){
        doFill = false
    }
    fun noStroke(){
        doStroke = false
    }
    fun line(x1: Number, y1: Number, x2: Number, y2: Number){
        if(doStroke) canvas?.drawLine(x1.toFloat(), y1.toFloat(),x2.toFloat(), y2.toFloat(), strokePaint)
    }
    fun circle(x: Number, y: Number, radius: Number){
        if(doStroke) canvas?.drawCircle(x.toFloat(), y.toFloat(), radius.toFloat(), strokePaint)
        if(doFill) canvas?.drawCircle(x.toFloat(), y.toFloat(), radius.toFloat(), fillPaint)
    }
}