fun insertionSort(array: Array<Int>) {
    for (i in 1 until array.size) {
        val tmp = array[i]
        var j = i
        while (j - 1 >= 0 && array[j - 1] > tmp) {
            array[j] = array[j - 1]
            j--
        }
        array[j] = tmp
    }
}

fun main() {
    val willSort = arrayOf(1, 6, 3, 7, 9, 2)
    insertionSort(willSort)
    println(willSort.toList())
}
