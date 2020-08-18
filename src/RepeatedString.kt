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

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {

    //find length of string
    //find total no of a in string
    //divide n by total
    //if divident not zero then modulus the same
    //multiply no of a with dividend
    //get modulus number and get the same number of character from string
    //if a occurs in there add it to the result

    var result: Long
    var numberOfA: Int = 0
    var len = s.length
    s.forEach {
        if (it == 'a')
            numberOfA = numberOfA.inc()
    }
    result = numberOfA * (n / len)
    if ((n % len) != 0L) {
        s.subSequence(0, (n % len).toInt()).forEach {
            if (it == 'a')
                result = result.inc()
        }
    }
    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
