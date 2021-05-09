fun shellSort(array: Array<Int>) {
    var gap = array.size / 2
    while (gap > 0) {
        for (i in gap until array.size step gap) {
            val tmp = array[i]
            var j = i
            while (j - gap >= 0 && array[j - gap] > tmp) {
                array[j] = array[j - gap]
                j -= gap
            }
            array[j] = tmp
        }
        gap /= 2
    }
}

fun main() {
    val willSort = arrayOf(81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15)
    shellSort(willSort)
    println(willSort.toList())
}
