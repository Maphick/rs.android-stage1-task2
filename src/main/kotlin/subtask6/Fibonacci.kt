package subtask6

import subtask4.Pangram

class Fibonacci {

    fun Fib(n: Int): Int {
        when (n) {
            0 -> return 0
            1 -> return 1
            2 -> return 1
            else -> {
                return Fib(n-1) + Fib (n-2)
            }
        }
    }


    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        var result = 0;
        var ind = 1
        while (ind < n) {
            var firstFactor = Fib(ind-1)
            var secondFactor = Fib(ind)
            var product  = firstFactor * secondFactor
            if (product == n)
                return intArrayOf(firstFactor, secondFactor, 1)
            if (product > n)
                return intArrayOf(firstFactor, secondFactor, 0)
            ind++
        }
        return intArrayOf(0, 0, 0)
    }
}



