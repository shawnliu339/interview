fun findMinAndMax(array: Array<Int>): Pair<Int, Int> {
    var min = array[0]
    var max = array[0]
    array.forEachIndexed { index, value ->
        if (min > value) {
            min = value
        }
        if (max < value) {
            max = value
        }
    }
    return min to max
}

fun countingSort(array: Array<Int>): Array<Int> {
    val (min, max) = findMinAndMax(array)
    val bucket = IntArray(max - min + 1) { 0 }

    // 统计数量
    array.forEach { bucket[it - min]++ }
    // 计算累加数量
    bucket.forEachIndexed { index, quantity ->
        if (index > 0) {
            bucket[index] = bucket[index - 1] + quantity
        }
    }

    val sorted = array.copyOf()
    for (index in array.lastIndex downTo 0) {
        val relativeIndex = array[index] - min
        val accumulativeQuantity = bucket[relativeIndex]--
        sorted[accumulativeQuantity - 1] = array[index]
    }
    return sorted
}

val willBeSort = arrayOf(1, 100, 8, 98, 64, 20, -1)
countingSort(willBeSort).toList()