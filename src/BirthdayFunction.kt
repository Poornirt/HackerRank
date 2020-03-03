// Complete the birthday function below.
fun birthday(segments: Array<Int>, d: Int, m: Int): Int {
    // d has to be sum of the segments
    // m has to number of segments
    var result: ArrayList<Int> = ArrayList()
    var count: Int = 0
    for (index in segments.indices) {
        var sum = 0
        var tempIndex = index
        var segmentIndex = 0
        while (segmentIndex < m) {
            sum += segments[tempIndex]
            tempIndex = tempIndex.inc()
            if (tempIndex > segments.size - 1) {
                break
            }
            segmentIndex = segmentIndex.inc()
        }
        if (sum == d) {
            count = count.inc()
        }
        result.add(sum)
    }
    return count
}


fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val s = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val dm = readLine()!!.trimEnd().split(" ")

    val d = dm[0].toInt()

    val m = dm[1].toInt()

    var result: Int = 0

    if (n <= 100 && (d in 1..31) && (m in 1..12)) {
        result = birthday(s, d, m)
    }

    println(result)
}
