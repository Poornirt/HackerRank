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

// Complete the circularArrayRotation function below.
fun circularArrayRotation(a: Array<Int>, k: Int, queries: Array<Int>): IntArray {
    var i = a.size - k
    if (i < 0) {
        i = 0
    }
    var j = 0
    val sortedArray = arrayListOf<Int>()
    val sortedArrayResult = arrayListOf<Int>()
    while (j < a.size) {
        sortedArray.add(a[i])
        i = i.inc()
        j = j.inc()
        if (i >= a.size)
            i = 0
    }
    j = 0
    while (j < queries.size) {
        sortedArrayResult.add(sortedArray[queries[j]])
        j = j.inc()
    }
    return sortedArrayResult.toIntArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nkq = scan.nextLine().split(" ")

    val n = nkq[0].trim().toInt()

    val k = nkq[1].trim().toInt()

    val q = nkq[2].trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val queries = Array<Int>(q, { 0 })
    for (i in 0 until q) {
        val queriesItem = scan.nextLine().trim().toInt()
        queries[i] = queriesItem
    }

    val result = circularArrayRotation(a, k, queries)

    println(result.joinToString("\n"))
}
