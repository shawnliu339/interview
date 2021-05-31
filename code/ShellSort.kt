fun shellSort(array: Array<Int>) {
    var gap = array.size / 2
    while (gap > 0) {
        for (i in gap until array.size) {
            val pivot = array[i]
            for (j in i - gap downTo 0 step gap) {
                if (pivot < array[j]) {
                    array[j + gap] = array[j]
                    array[j] = pivot
                } else {
                    break
                }
            }
        }
        gap /= 2
    }
}

fun main() {
    val willSort = arrayOf(81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15)
    shellSort(willSort)
    println(willSort.toList())
}
