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

// Complete the bonAppetit function below.
fun bonAppetit(bill: Array<Int>, k: Int, b: Int): Unit {
    //1) remove kth element from bill
    //2) add rest of the element
    //3) find half the amount
    //3) check if half and b are equal if so (Bon Appetit)
    //4) else subtract and show remaining amount
    var billList: MutableList<Int> = bill.toMutableList()
    billList.removeAt(k)
    if (billList.sum() / 2 == b) {
        print("Bon Appetit")
    } else {
        print(Math.abs((billList.sum() / 2)-b))
    }
}

fun main(args: Array<String>) {
    val nk = readLine()!!.trimEnd().split(" ")

    val n = nk[0].toInt()

    val k = nk[1].toInt()

    val bill = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val b = readLine()!!.trim().toInt()

    if(n in 2..100000 && k in 0..n)
    bonAppetit(bill, k, b)
}
