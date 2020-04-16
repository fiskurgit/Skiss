package oppen.skiss.lib.objects

class Circle(var coord: Coord, var radius: Float){
    companion object{
        fun from(x: Number, y: Number, radius: Number): Circle{
            return Circle(Coord(x.toFloat(), y.toFloat()), radius.toFloat())
        }
    }
}