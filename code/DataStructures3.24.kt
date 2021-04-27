class MyStack<T> {
    private val defaultSize = 10
    private val array = arrayOfNulls<Any>(defaultSize) as Array<T>

    private var stackOneSize = 0
    private var stackOneTop = 0

    private var stackTwoSize = 0
    private var stackTwoTop = array.size - 1

    fun pushStackOne(value: T) {
        if (stackOneSize + stackTwoSize >= array.size) {
            throw Exception("Stack one is full")
        }
        if (stackOneSize == 0) {
            array[stackOneTop] = value
            stackOneSize++
            return
        }

        stackOneTop++
        array[stackOneTop] = value
        stackOneSize++
    }

    fun pushStackTwo(value: T) {
        if (stackOneSize + stackTwoSize >= array.size) {
            throw Exception("Stack two is full")
        }
        if (stackTwoSize == 0) {
            array[stackTwoTop] = value
            stackTwoSize++
            return
        }

        stackTwoTop--
        array[stackTwoTop] = value
        stackTwoSize++
    }

    fun popStackOne(): T {
        if (stackOneSize <= 0) {
            throw Exception("Stack one is empty")
        }
        val target = array[stackOneTop]
        if (stackOneSize == 1) {
            stackTwoSize--
            return target
        }
        stackOneSize--
        stackOneTop--
        return array[stackOneTop]
    }

    fun popStackTwo(): T {
        if (stackTwoSize <= 0) {
            throw Exception("Stack two is empty")
        }
        val target = array[stackTwoTop]
        if (stackTwoSize == 1) {
            stackTwoSize--
            return target
        }
        stackTwoSize--
        stackTwoTop++
        return array[stackTwoTop]
    }

    fun printStackOne(): String {
        return buildString {
            append("[")
            append((0 until stackOneSize).map { array[it] }.joinToString())
            append("]")
        }
    }

    fun printStackTwo(): String {
        return buildString {
            append("[")
            append((array.size - 1 downTo stackTwoTop).map { array[it] }.joinToString())
            append("]")
        }
    }
}