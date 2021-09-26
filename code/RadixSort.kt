import java.util.*
import kotlin.math.pow

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

fun radixSort(array: Array<Int>) {
    val result = array.copyOf()
    val bucket = IntArray(10) { 0 }

    val (_, max) = findMinAndMax(array)
    val radix = max.toString().length
    for (i in 0 until radix) {
        val div = 10.0.pow(i).toInt()
        array.forEach { value ->
            val remainder = (value / div) % 10
            bucket[remainder]++
        }

        // 累加数量
        bucket.forEachIndexed { index, value ->
            if (index != 0) {
                bucket[index] = bucket[index - 1] + value
            }
        }

        for (j in array.lastIndex downTo 0) {
            val remainder = (array[j] / div) % 10
            // 对桶的累加数量自减非常重要！！
            val cumulativeQuantity = bucket[remainder]--
            result[cumulativeQuantity - 1] = array[j]
        }
        Arrays.fill(bucket, 0)
        result.copyInto(array)
    }
}

// 无法排列负数，如果需要排列负数，需要将桶扩大2倍，对负数另外排序。
val willBeSort = arrayOf(1, 100, 8, 98, 64, 20)
radixSort(willBeSort)
willBeSort.toList()