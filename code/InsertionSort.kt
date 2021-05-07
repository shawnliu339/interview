fun insertionSort(array: Array<Int>) {
    (1 until array.size).forEach { i ->
        val tmp = array[i]
        var j = i
        (j - 1 downTo 0).forEach inner@{
            if (array[j - 1] > tmp) {
                array[j] = array[j - 1]
            } else {
                return@inner
            }
            j--
        }
        array[j] = tmp
    }
}

fun main(args: Array<String>) {
    val willSort = arrayOf(1, 6, 3, 7, 9, 2)
    insertionSort(willSort)
    println(willSort.toList())
}
