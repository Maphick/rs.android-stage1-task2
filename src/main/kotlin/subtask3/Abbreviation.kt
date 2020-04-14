package subtask3

import subtask6.Fibonacci

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        var regex = "[a-z]*"
        for (letter in b)
        {
            regex += '['
            regex +=  letter
            regex +=  '|'
            regex +=  letter.toLowerCase()
            regex += ']'
            regex += "[a-z]*"
        }
        var regular = regex.toRegex()
        var res = regular.containsMatchIn(a)
        if (res)
            return "YES"
        else
            return "NO"
    }
}




