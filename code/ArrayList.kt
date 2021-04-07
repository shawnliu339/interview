@Suppress("UNCHECKED_CAST")
class MyArrayList<T> {
    companion object {
        const val DEFAULT_SIZE = 10
    }

    private var array: Array<T?> = arrayOfNulls<Any?>(DEFAULT_SIZE) as Array<T?>
    private var size: Int = 0

    // O(1)
    fun get(index: Int): T? {
        check(index)
        return array[index]
    }

    // O(1)
    fun set(index: Int, element: T): T? {
        if (index < 0 || index >= size) {
            throw Exception("Bad")
        }

        val old = array[index] ?: throw Exception("Bad")
        array[index] = element
        return old
    }

    fun add(element: T) {
        return add(size, element)
    }

    /**
     * O(n)
     */
    fun add(index: Int, element: T) {
        if (index < 0 || index > size) {
            throw Exception("Bad")
        }

        if (array.size - size < 1) {
            enlarge()
        }
        for (i in size - 1 downTo index) {
            array[i + 1] = array[i]
        }
        array[index] = element
        size++
    }

    private fun enlarge() {
        array = if (array.isEmpty()) {
            array.copyOf(10)
        } else {
            array.copyOf(array.size * 2)
        }
    }

    fun size(): Int {
        return size
    }

    // O(n)
    fun remove(index: Int): T? {
        check(index)
        val old = array[index]
        for (i in index until size) {
            array[i] = array[i + 1]
        }
        size--
        return old
    }

    override fun toString(): String {
        return array.toList().toString()
    }

    private fun check(index: Int) {
        if (index < 0 || index >= size) {
            throw Exception("The index of $index is over size.")
        }
    }
}