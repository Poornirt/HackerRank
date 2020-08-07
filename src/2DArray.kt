import java.util.*

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {

    var list = arrayListOf<Int>()
    var finalList = arrayListOf<Int>()

    var i = 0
    var j = 0
    var x = 0
    var y = 0
    var countJ = 1
    var countI = 0

    while (x < arr.size) {
        while (i < arr.size) {
            while (j < arr.size) {
                if (countI == arr.size-3)
                    break
                //add value
                if (countJ == 2) {
                    list.add(arr[i][j+1])
                    break
                }
                list.add(arr[i][j])
                countI = countI.inc()
                j = j.inc()
            }
            if (countJ == arr.size-3) {
                finalList.add(list.sum())
                list = arrayListOf<Int>()
                i -= 2
                j -= 2
                if (j == arr.size - 2 || i == arr.size - 2) {
                    i += 1
                    j = 0
                    countI = 0
                    countJ = 1
                    x -= (arr.size - 2)
                    break
                }
                countI = 0
                countJ = 1
                break
            }
            countJ = countJ.inc()
            i = i.inc()
            j = x
            countI = 0
        }
        x = x.inc()
    }


    return finalList.max()!!
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
//-9 -9 -9 1 1 1
//0 -9 0 4 3 2
//-9 -9 -9 1 2 3
//0 0 8 6 6 0
//0 0 0 -2 0 0
//0 0 1 2 4 0