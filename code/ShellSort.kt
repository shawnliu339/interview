fun shellSort(array: Array<Int>) {
    val intervals = arrayOf(5, 3, 1)
    intervals.forEach { interval ->
        (interval until array.size step interval).forEach { i ->
            val tmp = array[i]
            var j = i
            while (j - interval >= 0 && array[j - interval] > tmp) {
                array[j] = array[j - interval]
                j -= interval
            }
            array[j] = tmp
        }
    }
}

fun main() {
    val willSort = arrayOf(81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15)
    shellSort(willSort)
    println(willSort.toList())
}
