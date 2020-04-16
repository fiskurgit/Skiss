package oppen.skiss.lib

import android.graphics.Canvas
import android.graphics.Paint
import oppen.skiss.lib.objects.Coord

abstract class SkissSyntaxBase {

    class SkissPaint(var active: Boolean = false): Paint(){
        fun draw(operation: () -> Unit){
            if(active) operation.invoke()
        }
    }

    private val fillPaint = SkissPaint().apply {
        style = Paint.Style.FILL
        isAntiAlias = true
    }
    private val strokePaint = SkissPaint().apply {
        style = Paint.Style.STROKE
        isAntiAlias = true
    }

    var width = -1
    var height = -1

    var canvas: Canvas? = null

    fun background(color: Int){
        canvas?.drawColor(color)
    }

    fun smooth(){
        strokePaint.isAntiAlias = true
        fillPaint.isAntiAlias = true
    }

    fun noSmooth(){
        strokePaint.isAntiAlias = false
        fillPaint.isAntiAlias = false
    }

    fun stroke(color: String){
        strokePaint.apply {
            this.color = color(color)
            active = true
        }
    }

    fun strokeWeight(weight: Number){
        strokePaint.apply{
            strokeWidth = weight.toFloat()
        }
    }

    fun stroke(color: Int){
        strokePaint.apply {
            this.color = color
            active = true
        }
    }

    fun fill(color: String){
        fillPaint.apply {
            this.color = color(color)
            active = true
        }
    }

    fun fill(color: Int){
        fillPaint.apply{
            this.color = color
            active = true
        }
    }

    fun noFill(){
        fillPaint.active = false
    }

    fun noStroke(){
        strokePaint.active = false
    }

    fun line(x1: Number, y1: Number, x2: Number, y2: Number){
        strokePaint.draw {
            canvas?.drawLine(x1.toFloat(), y1.toFloat(),x2.toFloat(), y2.toFloat(), strokePaint)
        }
    }

    fun lines(lines: List<Pair<Coord, Coord>>){
        strokePaint.draw {
            canvas?.drawLines(lines.flatMap {
                arrayListOf(it.first.x, it.first.y, it.second.x, it.second.y)
            }.toFloatArray(), strokePaint)
        }
    }

    fun circle(x: Number, y: Number, radius: Number){
        strokePaint.draw {
            canvas?.drawCircle(x.toFloat(), y.toFloat(), radius.toFloat(), strokePaint)
        }
        fillPaint.draw{
            canvas?.drawCircle(x.toFloat(), y.toFloat(), radius.toFloat(), fillPaint)
        }
    }

    fun square(x: Number, y: Number, diameter: Number){
        strokePaint.draw {
            canvas?.drawRect(x.toFloat(), y.toFloat(), (x.toFloat() + diameter.toFloat()),(y.toFloat() + diameter.toFloat()),  strokePaint)
        }
        fillPaint.draw{
            canvas?.drawRect(x.toFloat(), y.toFloat(), (x.toFloat() + diameter.toFloat()),(y.toFloat() + diameter.toFloat()),  fillPaint)
        }
    }

    fun points(points: List<Coord>){
        strokePaint.draw {
            canvas?.drawPoints(points.flatMap {
                arrayListOf(it.x, it.y)
            }.toFloatArray(), strokePaint)
        }
    }

    fun point(point: Coord){
        strokePaint.draw {
            canvas?.drawPoint(point.x, point.y, strokePaint)
        }
    }
}