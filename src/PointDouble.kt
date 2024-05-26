import java.awt.geom.Point2D
import kotlin.math.exp

data class PointDouble(private val x :Double,private val y:Double ) {
    private val coordX :Double =x
        get() = field
    private val coordY :Double =y
        get() = field

    init{}
    constructor(point:PointDouble) : this(point.x,point.y)

    override fun toString():String = "[$coordX , $coordY]"
}