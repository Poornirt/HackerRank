import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.math.abs
import kotlin.ranges.*
import kotlin.text.*

// Complete the formingMagicSquare function below.
fun formingMagicSquare(s: Array<Array<Int>>): Int {

    var resultList = ArrayList<Int>()
    var arry = s.flatten()
    var arrayOfPossiblity: Array<Array<Int>> = arrayOf(
        arrayOf(8, 1, 6, 3, 5, 7, 4, 9, 2),
        arrayOf(6, 1, 8, 7, 5, 3, 2, 9, 4),
        arrayOf(4, 9, 2, 3, 5, 7, 8, 1, 6),
        arrayOf(2, 9, 4, 7, 5, 3, 6, 1, 8),
        arrayOf(8, 3, 4, 1, 5, 9, 6, 7, 2),
        arrayOf(4, 3, 8, 9, 5, 1, 2, 7, 6),
        arrayOf(6, 7, 2, 1, 5, 9, 8, 3, 4),
        arrayOf(2, 7, 6, 9, 5, 1, 4, 3, 8)
    )
    var i: Int = 0
    var j: Int = 0
    var count: Int = 0
    while (i < arrayOfPossiblity.size) {
        while (j < arrayOfPossiblity[i].size) {
            count += Math.abs(arry[j] - arrayOfPossiblity[i][j])
            j = j.inc()
        }
        resultList.add(count)
        count = 0
        j = 0
        i = i.inc()
    }

    return resultList.min()!!
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = Array(3) { Array<Int>(3) { 0 } }

    for (i in 0 until 3) {
        s[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = formingMagicSquare(s)

    println(result)
}
