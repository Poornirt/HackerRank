import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.tan

// Complete the climbingLeaderboard function below.
fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): ArrayList<Int> {

    //rank the score
    //find highest and rank as 1 and followed by
    //if scores are equal then same rank
    var finalList = arrayListOf<Int>()
    val hashRank = HashMap<Int, Int>()
    var rank: Int = 0
    var i: Int = 0
    while (i < scores.count()) {
        if (i + 1 < scores.count() && scores[i] == scores[i + 1]) {
            i = i.inc()
            continue
        }
        hashRank.put(++rank, scores[i])
        i = i.inc()
    }
    i = 0
    var j = hashRank.entries.size
        while (j >= 1 && i < alice.count()) {
            if (alice[i] >= hashRank[1]!!) {
                finalList.add(1)
                j = hashRank.entries.size
                i = i.inc()
                continue
            }
            if (alice[i] <= hashRank[hashRank.count()]!!) {
                finalList.add(if(alice[i] == hashRank[hashRank.count()]!!)hashRank.count() else hashRank.count() + 1)
                j = hashRank.entries.size
                i = i.inc()
                continue
            }
            if (hashRank[j - 1]!=null && alice[i] >= hashRank[j]!! && alice[i] <= hashRank[j - 1]!!) {
                when {
                    alice[i]==hashRank[j] -> finalList.add(j)
                    alice[i]==hashRank[j-1] -> finalList.add(j-1)
                    else -> finalList.add(j)
                }
                j = hashRank.entries.size
                i = i.inc()
                continue
            }
            j = j.dec()
        }

    return finalList
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val scoresCount = scan.nextLine().trim().toInt()

    val scores = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val aliceCount = scan.nextLine().trim().toInt()

    val alice = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = climbingLeaderboard(scores, alice)

    println(result.joinToString("\n"))
}
