package subtask1

import subtask2.TimeConverter
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

    class DateFormatter {
        val daysOfWeek = mutableMapOf(
            DayOfWeek.MONDAY to "понедельник",
            DayOfWeek.MONDAY to "понедельник",
            DayOfWeek.TUESDAY to "вторник",
            DayOfWeek.WEDNESDAY to "среда",
            DayOfWeek.THURSDAY to "четверг",
            DayOfWeek.FRIDAY to "пятница",
            DayOfWeek.SATURDAY to "суббота",
            DayOfWeek.SUNDAY to "воскресенье"
        )

        val monthes = mutableMapOf(
            1 to "января",
            2 to "февраля",
            3 to "марта",
            4 to "апреля",
            5 to "мая",
            6 to "июня",
            7 to "июля",
            8 to "августа",
            9 to "сентября",
            10 to "октября",
            11 to "ноября",
            12 to "декабря"
        )

        @Throws(ParseException::class)
        fun haveFun(dateStr: String) {
            var formatter = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
            val date = formatter.parse(dateStr)
        }



        // TODO: Complete the following function
        fun toTextDay(day: String, month: String, year: String): Any? {
            var dayInt = day.toInt()
            var monthInt = month.toInt()
            var yearInt = year.toInt()
            try {
                val date = LocalDate.of(yearInt, monthInt, dayInt)
                return day + " " + monthes[monthInt] + ", " + daysOfWeek[date.dayOfWeek]
            }
            catch(ex:Exception)
            {
                return "Такого дня не существует"
            }

        }
}



