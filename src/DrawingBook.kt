import java.util.*

class DrawingBook {
    var mList = arrayListOf<Int>()
    var mPagecount: Int = 0
    var mStart: Int = 1
    var mEnd: Int = 0
    lateinit var mType: String
    fun pageCount(n: Int, p: Int): Int {
        mType = if (n % 2 == 0) "even" else "odd"
        mEnd = n
        if (mType == "odd" && (mEnd == p || --mEnd == p)) {
            mList.add(0)
        }
        if (mStart == p || mEnd == p) {
            mList.add(0)
        } else {
            while (mStart < p) {
                mStart += 2
                mPagecount++
                if (p in 1..mStart) {
                    mList.add(mPagecount)
                    break
                }
            }
            mPagecount = 0
            while (mEnd > p) {
                mEnd -= 2
                mPagecount++
                if (p in n downTo mEnd) {
                    mList.add(mPagecount)
                    break
                }
            }
        }
        return mList.min()!!
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val p = scan.nextLine().trim().toInt()

    val result = DrawingBook().pageCount(n, p)

    println(result)
}
