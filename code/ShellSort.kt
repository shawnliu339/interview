/**
 * 第一种写法，与网上多数给出的动图不一致。
 * 该算法先比较每一组中的第一组数，然后，比较每一组中的第二组数，直至完成排序。
 * 具体解释可参见自己整理的数据结构预算法-排序.md的文章。
 */
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

/**
 * 代码易实现版的另一个实现。（该实现比较符合自己的编码风格）
 */
fun shellSort(array: Array<Int>) {
    var gap = array.size / 2
    while (gap > 0) {
        for (i in gap..array.lastIndex) {
            val pivot = array[i]
            var j = i
            while (j - gap >= 0 && pivot < array[j - gap]) {
                array[j] = array[j - gap]
                j -= gap
            }
            array[j] = pivot
        }
        gap /= 2
    }
}

/**
 * 第二种写法，与该网站的动图的执行顺序完全一致。
 * https://www.cnblogs.com/onepixel/p/7674659.html
 * 先将第一组中的所有数比较完成，然后再比较第二组数中的所有数，以此类推。
 */
fun shellSort2(array: Array<Int>) {
    val random = 2
    for (gap in random downTo 1) {
        for (set in 0..gap) {
            for (i in (set + gap + 1)..array.lastIndex step (gap + 1)) {
                var j = i
                val pivot = array[j]
                while (j - gap - 1 >= set && pivot < array[j - gap - 1]) {
                    array[j] = array[j - gap - 1]
                    j = j - gap - 1
                }
                array[j] = pivot
            }
        }
    }
}

fun main() {
    val willSort = arrayOf(81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15)
    shellSort(willSort)
    println(willSort.toList())
}
