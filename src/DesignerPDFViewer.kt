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

// Complete the designerPdfViewer function below.
fun designerPdfViewer(h: Array<Int>, word: String): Int {
    var hashMap = HashMap<Char, Int>()
    var letter = 'a'
    var list= mutableListOf<Int>()
    var i = 0
    while (letter <= 'z' && h.size <= 26) {
        hashMap.put(letter, h[i])
        letter = letter.inc()
        i = i.inc()
    }
        word.forEach {
            list.add(hashMap[it]!!)
        }

    return list.max()!! * word.length
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val h = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val word = scan.nextLine()

    val result = designerPdfViewer(h, word)

    println(result)
}
