import java.util.*

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var count: Int = 0
    var list = arr
    var temp: Int
    var arr = arr.sortedArray()

    for (i in arr.indices) {
        if (arr[i] != list[i]) {
            count++
            for (j in i + 1 until arr.size) {
                if (arr[j] == list[i]) {
                    val tmp = arr[j]
                    arr[j] = arr[i]
                    arr[i] = tmp
                    break
                }
            }
        }
    }

    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}
//100
//8 45 35 84 79 12 74 92 81 82 61 32 36 1 65 44 89 40 28 20 97 90 22 87 48 26 56 18 49 71 23 34 59 54 14 16 19 76 83 95 31 30 69 7 9 60 66 25 52 5 37 27 63 80 24 42 3 50 6 11 64 10 96 47 38 57 2 88 100 4 78 85 21 29 75 94 43 77 33 86 98 68 73 72 13 91 70 41 17 15 67 93 62 39 53 51 55 58 99 46
