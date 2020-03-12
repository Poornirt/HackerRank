import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the migratoryBirds function below.
fun migratoryBirds(arr: Array<Int>):Int {
    //find repeated number
    //get highest frequency
    //if(high freq is repeated) -> get which is the lowest number
    //and print that
    var numberConvertedList: MutableList<Int> = arr.toMutableList()
    var repeatedList = numberConvertedList.groupingBy { it }.eachCount().filter { it.value > 1 }.toMutableMap()
    //  println(numberConvertedList.groupingBy { it }.eachCount().filter { it.value > 1 }.forEach
    //  { (t, u) -> println("$t  $u") })
//    println(numberConvertedList.groupingBy { it }.eachCount().filter { it.value > 1}.toList().forEachIndexed { index, pair ->
//        println("$pair".toList())
//    })
    // println(repeatedList.toTypedArray().maxBy { it.first })
    //print(repeatedList)
    val indexOfValue = repeatedList.values.max()
    var result = repeatedList.filter { it.value == indexOfValue }.toList().minBy { indexOfValue ->
        indexOfValue.first
    }
    return result!!.toList()[0]
}
//{4=24999, 3=24999}
fun main(args: Array<String>) {
    val arrCount = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    var result = migratoryBirds(arr)


    println(result)
}
