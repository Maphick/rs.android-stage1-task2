package subtask5


import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofLocalizedTime
import java.time.format.DateTimeFormatterBuilder
import java.time.format.FormatStyle
import java.util.Locale
import javax.swing.text.DateFormatter
import kotlin.reflect.KClass


class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        var sum = 0
        var conc = ""
        var date = LocalDate.parse("0000-01-01")
        for ((index, value) in blockA.withIndex()) {
            if (value is Int)
                {
                    sum = sum + value
                    continue
                }
            if (value is String)
                {
                    conc += value
                    continue
                }
            if (value is LocalDate)
            {
                date  = if (date.isAfter(value as LocalDate?)) date else value
            }
        }
        if (blockB == Int::class)
            return  sum
        if (blockB == String::class)
            return  conc
        if (blockB == LocalDate::class) {
            val dateRes = date.format(DateTimeFormatter.ofPattern("d.M.y"))
            return dateRes
        }
        return Unit
    }

}