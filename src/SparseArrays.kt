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

// Complete the matchingStrings function below.
fun matchingStrings(strings: Array<String>, queries: Array<String>): ArrayList<Int> {

    var result = arrayListOf<Int>()
    var i = 0
    var j = 0
    var count = 0
    while (j < queries.size) {
        while (i < strings.size) {
            if (queries[j] == strings[i]) {
                count = count.inc()
            }
            i = i.inc()
        }
        result.add(count)
        j = j.inc()
        count = 0
        i = 0
    }
    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val stringsCount = scan.nextLine().trim().toInt()

    val strings = Array<String>(stringsCount, { "" })
    for (i in 0 until stringsCount) {
        val stringsItem = scan.nextLine()
        strings[i] = stringsItem
    }

    val queriesCount = scan.nextLine().trim().toInt()

    val queries = Array<String>(queriesCount, { "" })
    for (i in 0 until queriesCount) {
        val queriesItem = scan.nextLine()
        queries[i] = queriesItem
    }

    val res = matchingStrings(strings, queries)

    println(res.joinToString("\n"))
}
