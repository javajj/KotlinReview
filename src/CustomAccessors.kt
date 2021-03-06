import kotlin.math.roundToInt
import kotlin.math.sqrt

class Person(firstName: String, lastName:String){
    val fullName = "$firstName $lastName"
}

class TvMath{
    companion object{
        fun getDiagonal(width: Double, height: Double): Int{
            val result = sqrt(width * width + height * height)
            return  result.roundToInt()
        }

        fun getWidthAndHeight(diagonal: Int, ratioWidth: Double, ratioHeight: Double): Pair<Double, Double> {
            val ratioDiagonal = sqrt(ratioWidth * ratioWidth + ratioHeight * ratioHeight)
            val height = diagonal * ratioHeight / ratioDiagonal
            val width  = height * ratioWidth / ratioHeight

            return Pair(width, height)
        }
    }
}

class Television(var height: Double, var width: Double)
{
    var diagonal: Int
    get() {
       return TvMath.getDiagonal(width, height)
    }
        set(value) {
            val size = TvMath.getWidthAndHeight(
                diagonal = value,
                ratioWidth = 16.0,
                ratioHeight = 9.0
            )
            width = size.first
            height = size.second
        }
}

class Level( val id: Int, val boss: String, var unlocked: Boolean){

    companion object{
        var hightestLevel = 2
    }
}


fun main() {
    val jamie = Person("Jamie", "Mason-Wright")
    println(jamie.fullName)

    val tv = Television(width = 95.87, height = 53.93)
    println(tv.diagonal)

    tv.width = tv.height
    println(tv.diagonal)

    tv.diagonal = 65
    println("Thats a ${tv.width} tv Jamie")

    val level1 = Level(id = 1, boss = "Outside Cat", unlocked = true)
    val level2 = Level(id = 2, boss = "Laser Pointer", unlocked = false)
    val level3 = Level(id = 3, boss = "Attic Sound", unlocked = false)
    val level4 = Level(id = 4, boss = "Vacuum", unlocked = false)

    println("Highest level is ${Level.hightestLevel}")

}

