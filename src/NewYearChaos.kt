import jdk.nashorn.internal.objects.NativeArray.indexOf
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
import kotlin.math.max
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the minimumBribes function below.
fun minimumBribes(q: Array<Int>): Unit {
    var count: Int = 0
    var i = q.size - 1
    while (i >= 0) {
        if(q[i]-((i+1))>2){
            println("Too chaotic")
            return
        }
        var j = max(0,q[i] - 2)
        while (j < i) {
            if(q[j]>q[i])
                count = count.inc()
            j = j.inc()
        }
        i = i.dec()
    }
    println(count)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        minimumBribes(q)

    }
}
