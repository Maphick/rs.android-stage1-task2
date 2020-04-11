package subtask5

import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        val properties = System.getProperties()

        throw NotImplementedError("Not implemented")
    }
}

fun main() {
    val blockA = arrayOf(1, "4", 2, "3")
    var result = robotPaphnutiy.getData(blockA, String::class)
    print(result)
    //assertEquals("43", robotPaphnutiy.getData(blockA, String::class))
}
