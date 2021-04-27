class MyArrayQueue<T> {
    companion object {
        const val defaultSize = 10
    }

    private val array = arrayOfNulls<Any>(defaultSize) as Array<T>

    private var currentSize = 0
    private var front = 0
    private var back = 0

    fun enqueue(value: T) {
        if (currentSize == array.size) {
            throw Exception("The queue is full!")
        }
        if (currentSize == 0) {
            front = back
            array[front] = value
            currentSize++
            return
        }

        if (back + 1 >= array.size) {
            back = 0
        } else {
            back++
        }
        array[back] = value
        currentSize++
    }

    fun dequeue(): T {
        if (currentSize == 0) {
            throw Exception("The queue is empty")
        }

        val target = array[front]
        if (front + 1 >= array.size) {
            front = 0
        } else {
            front++
        }
        currentSize--
        return target
    }

    override fun toString(): String {
        return buildString {
            append("[")
            if (front <= back) {
                append(
                    (front..back).map {
                        array[it]
                    }.joinToString()
                )
            } else {
                append(
                    (front until array.size).map { array[it] }.joinToString()
                )
                append(", ")
                append(
                    (0..back).map { array[it] }.joinToString()
                )
            }
            append("]")
        }
    }
}