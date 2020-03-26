import java.io.*
import java.math.*
import java.text.*
import java.util.*
import java.util.regex.*
import kotlin.collections.ArrayList

/*
 * Complete the getMoneySpent function below.
 */
fun getMoneySpent(keyboards: Array<Int>, drives: Array<Int>, b: Int): Int? {
    /*
     * Write your code here.
     */
    var result: MutableList<Int> = ArrayList()
    keyboards.forEach { i ->
        drives.forEach { j ->
            result.add(i + j)
        }
    }
    result.forEach { i ->
        if (i<=b)
          println(i)
    }
    var maxValue: Int? = result.max()
    //result.takeWhile {  }
    return maxValue

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val bnm = scan.nextLine().split(" ")

    val b = bnm[0].trim().toInt()

    val n = bnm[1].trim().toInt()

    val m = bnm[2].trim().toInt()

    val keyboards = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val drives = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    /*
     * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
     */

    val moneySpent = getMoneySpent(keyboards, drives, b)

    println(moneySpent)
}
