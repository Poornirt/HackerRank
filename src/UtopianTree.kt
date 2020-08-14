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

// Complete the utopianTree function below.
fun utopianTree(n: Int): Int {
    var i: Int = 1
    var initialHeight: Int = 1
    var result: Int = 0
    // initialHeight double
    // initialHeight plus one
    if (n == 0) {
        result = 1
    } else {
        while (i <= n) {
            if (i % 2 != 0)
                initialHeight += initialHeight
            else
                initialHeight += 1
            i = i.inc()
        }
        result = initialHeight
    }
    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    var list= arrayListOf<Int>()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val result = utopianTree(n)

        list.add(result)
    }
    for(i in list){
        println(i)
    }
}
