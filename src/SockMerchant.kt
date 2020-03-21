import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {

    //1)loop through array to find mathcing number
    //2) remove both from the list
    var sockList: MutableList<Int> = ar.toMutableList()
    var count = 0
    //println(sockList.groupingBy { it }.eachCount())
    sockList.groupingBy { it }.eachCount().forEach { t, u ->
        var pair = 2
        if (u >= 2) {
            for (pair in 2..u step 2) {
                count = count.inc()
            }
        }
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    var result: Int = 0
    if (n in 1..100) {
        result = sockMerchant(n, ar)
    }

    println(result)
}
