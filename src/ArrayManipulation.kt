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

// Complete the arrayManipulation function below.
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    var i = 0
    var result: Long = 0L
    val list = IntArray(n+1)
    while (i < queries.size) {
        val start = queries[i][0]
        var end = queries[i][1]
        list[start] += queries[i][2]
        list[end] -= queries[i][2]
        i = i.inc()
    }
    list.forEach {
        if(it>0) {
            println(it)
            result += it
        }
    }
    return result
}
//10 3
//1 5 3
//4 8 7
//6 9 10
fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nm = scan.nextLine().split(" ")

    val n = nm[0].trim().toInt()

    val m = nm[1].trim().toInt()

    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        queries[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    println(result)
}

//10 3
//1 5 3
//4 8 7
//6 9 1