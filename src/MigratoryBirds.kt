import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the migratoryBirds function below.
fun migratoryBirds(arr: Array<Int>): Int {

    var numberConvertedList: MutableList<Int> = arr.toMutableList()
    var repeatedList = numberConvertedList.groupingBy { it }.eachCount().filter { it.value > 1 }
    val indexOfValue = repeatedList.values.max()
    val result = repeatedList.filter { it.value == indexOfValue }.toList().minBy { indexOfValue ->
        indexOfValue.first
    }
    return result!!.toList()[0]
}

fun main(args: Array<String>) {
    val arrCount = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    var result = migratoryBirds(arr)


    println(result)
}
