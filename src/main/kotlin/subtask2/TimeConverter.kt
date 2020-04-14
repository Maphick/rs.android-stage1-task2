package subtask2

import java.util.*



class TimeConverter {
    val timemap = mutableMapOf(1 to "one", 2 to "two",
    3 to "three",
    4 to "four",
    5 to "five",
    6 to "six",
    7 to "seven",
    8 to "eight",
    9 to "nine",
    10 to "ten",
    11 to "eleven",
    12 to "twelve",
        20 to "twenty",
        30 to "thirty",
        40 to "forty",
        50 to "fifty"
    )


    fun intToText(number: Int): String {
        var numberToText = ""
        if (((number >=1) and (number <= 12)) or (number % 10 == 0))
            numberToText = timemap[number].toString()
        else
        {
            var firstPart = number / 10
            var secondPart = number % 10
            numberToText = timemap[firstPart*10].toString() + " " + timemap[secondPart].toString()
        }
        return  numberToText
    }


    // TODO: Complete the following function
    fun toTextFormat(hour: String, minute: String): String {
        var intMinutes = minute.toInt()
        var intHours = hour.toInt()
        if (intMinutes >= 60)
            return ""
        when (minute)
        {
            "00" -> return  intToText(intHours ) + " o' clock"
            "01" -> return  "one minute past " + intToText(intHours)
            "15" -> return  "quarter past " + intToText(intHours )
            "30" -> return  "half past " + intToText(intHours )
            "45" -> return  "quarter to " + intToText(intHours+1)
            else -> {
                if ((intMinutes >= 1) and (intMinutes <=30))
                    return intToText(intMinutes) + " minutes past " + intToText(intHours )
                else
                    return intToText(60-intMinutes) + " minutes to " + intToText(intHours + 1)
            }

        }

        throw NotImplementedError("Not implemented")
    }
}



