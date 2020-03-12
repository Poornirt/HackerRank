import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the divisibleSumPairs function below.
fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
    var j: Int
    var count = 0

    for (i in ar.indices) {
        j = 0
        while (j < ar.size) {
            if ((ar[i] + ar[j]) % k == 0 && i < j) {
                println("${ar[i]} and ${ar[j]}")
                count = count.inc()
            }
            j = j.inc()
        }
    }
    return count
}
//100 66
//50 44 77 66 70 58 9 59 74 82 87 15 10 95 10 81 2 4 87 85 28 96 76 18 86 91 94 59 19 58 98 48 38 70 36 38 66 9 72 54 23 23 17 18 8 16 9 56 12 59 73 31 10 62 83 84 28 91 29 22 73 22 3 75 26 31 93 57 15 32 46 74 99 10 15 58 60 53 41 49 71 59 4 20 38 78 1 94 76 5 70 68 42 34 77 28 19 25 20 15

//5 2
//5 9 10 7 4
fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    if (n in 2..100 && k in 1..100) {
        val result = divisibleSumPairs(n, k, ar)
        println(result)
    }
}
//even
// odd-odd num  5,9,7- 1,1,1
// even-even num 10,4 - 1
//odd
//odd-even
//odd-odd
//even-even
