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

enum class Steps(val value: Int) {
    SEA_LEVEL(0), D(-1), U(1)
}

// Complete the countingValleys function below.
fun countingValleys(n: Int, s: String): Int {
    var mNoOfvalleys = 0
    var mCurrentPosition = 0
    var mPrevious = 0
    var stepList: MutableList<Char> = s.toMutableList()
    for (s in stepList) {
        when (s) {
            'U' -> {
                mCurrentPosition = mCurrentPosition + Steps.U.value
            }
            'D' -> {
                mCurrentPosition = mCurrentPosition + Steps.D.value
            }
        }
        if (mPrevious == -1 && mCurrentPosition == 0) {
            mNoOfvalleys = mNoOfvalleys.inc()
        }
        mPrevious = mCurrentPosition
    }
    return mNoOfvalleys
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}
