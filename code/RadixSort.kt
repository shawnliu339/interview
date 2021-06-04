import kotlin.math.pow

val array = arrayOf(99, 19, 4, 3, 25, 3, 7, 4, 75, 3, 2)
fun radixSort(array: Array<Int>, length: Int) {
    val buckets = (0..9).map { it to mutableListOf<Int>() }.toMap()
    for (i in 1..length) {
        array.forEach {
            val remain = (it % (10.0).pow(i).toInt()) / (10.0).pow(i - 1).toInt()
            buckets.getValue(remain).add(it)
        }

        var start = 0
        while (start <= array.size - 1) {
            for ((_, list) in buckets) {
                list.forEach { num ->
                    array[start++] = num
                }
                list.clear()
            }
        }
    }
}

radixSort(array, 2)
array.toList()
