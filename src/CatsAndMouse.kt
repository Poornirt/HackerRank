import java.util.*
import kotlin.io.*
import kotlin.text.*


// Complete the catAndMouse function below.
fun catAndMouse(x: Int, y: Int, z: Int): String {

    var xValue = Math.abs(x - z)
    var yValue = Math.abs(y - z)

    var result = if (xValue == yValue) {
        "Mouse C"
    } else if (xValue > yValue) {
        "Cat B"
    } else {
        "Cat A"
    }

    return result

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 0..q) {
        var xyz = scan.nextLine().trim().split(" ")

        val x = xyz[0].trim().toInt()

        val y = xyz[1].trim().toInt()

        val z = xyz[2].trim().toInt()

        val result = catAndMouse(x, y, z)

        println(result)
    }

}