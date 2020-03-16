import java.time.LocalDate
import java.util.*
import kotlin.io.*
import kotlin.text.*

enum class CalendarType {
    GREGORIAN, JULIAN, TRANSITION
}

// Complete the dayOfProgrammer function below.
fun dayOfProgrammer(year: Int): String {
    // 1) 1700 to 1917 Julian(official)
    // 2) 1919 gregorian
    // 3) transition 1918 feb 14 is 32nd day
    // 4) leap year divisible by 4 (Julian)
    // 5) leap year divisible by 400 and 4 not 100 (Gregorian)
    var leapYear: Boolean
    var result: String = ""
    var mProgrammerDay: Int
    var typeOfCalendar: String = if (year in 1700..1917) {
        CalendarType.JULIAN.toString()
    } else if (year in 1919..2700) {
        CalendarType.GREGORIAN.toString()
    } else {
        CalendarType.TRANSITION.toString()
    }

    when (typeOfCalendar) {
        CalendarType.JULIAN.toString() -> {
            var julianCalendar: Calendar = Calendar.getInstance()
            julianCalendar.set(Calendar.YEAR, year)
            julianCalendar.set(Calendar.MONTH, 1)
            julianCalendar.set(Calendar.DATE, 1)
            leapYear = findLeapYearOrNot(year, CalendarType.JULIAN.toString())
            if (year == 1700 || year == 1800 || year == 1900) {
                julianCalendar.add(Calendar.DAY_OF_MONTH, 253)
            } else {
                julianCalendar.add(Calendar.DAY_OF_MONTH, 254)
            }
            var date = julianCalendar.get(Calendar.DAY_OF_MONTH)
            String.format("%02d", date)
            var month = julianCalendar.get(Calendar.MONTH)
            result = "${String.format("%02d", date)}.${String.format("%02d", month)}.$year"

        }
        CalendarType.GREGORIAN.toString() -> {
            var gregorianCalendar: Calendar = Calendar.getInstance()
            gregorianCalendar.set(Calendar.YEAR, year)
            gregorianCalendar.set(Calendar.MONTH, 1)
            gregorianCalendar.set(Calendar.DATE, 1)

            leapYear = findLeapYearOrNot(year, CalendarType.GREGORIAN.toString())
            gregorianCalendar.add(Calendar.DAY_OF_MONTH, 254)

            var date = gregorianCalendar.get(Calendar.DAY_OF_MONTH)
            var month = gregorianCalendar.get(Calendar.MONTH)
            result = "${String.format("%02d", date)}.${String.format("%02d", month)}.$year"

        }
        CalendarType.TRANSITION.toString() -> {
            var transitionCalendar: Calendar = Calendar.getInstance()
            transitionCalendar.set(Calendar.YEAR, year)
            transitionCalendar.set(Calendar.MONTH, 1)
            transitionCalendar.set(Calendar.DATE, 1)
            transitionCalendar.add(Calendar.FEBRUARY, -15)
            transitionCalendar.add(Calendar.DATE, 267)
            var date = transitionCalendar.get(Calendar.DATE)
            var month = transitionCalendar.get(Calendar.MONTH)
            result = "${String.format("%02d", date)}.${String.format("%02d", month)}.$year"

        }
    }

    return result
}

fun findLeapYearOrNot(year: Int, calendarType: String): Boolean {
    if (calendarType == CalendarType.JULIAN.toString()) {
        if (year % 4 == 0) {
            return true
        }
        return false
    } else if (calendarType == CalendarType.GREGORIAN.toString()) {
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            return true
        }
        return false
    }
    return false
}

fun main(args: Array<String>) {
    val year = readLine()!!.trim().toInt()
    if (year in 1700..2700) {
        val result = dayOfProgrammer(year)
        println(result)
    }
}
