package oppen.skiss.lib.objects

class Line(var start: Coord, var end: Coord){
    companion object{
        fun from(x1: Number, y1: Number, x2: Number, y2: Number): Line{
            return Line(Coord(x1.toFloat(), y1.toFloat()), Coord(x2.toFloat(), y2.toFloat()))
        }
    }
}