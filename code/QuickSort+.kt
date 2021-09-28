fun main() {
    val array = arrayOf(3, 67, 1, 3, 6, 2)
    quickSort(array)
    array.toList().toString()
}

fun quickSort(willBeSorted: Array<Int>) {
    quickSort(willBeSorted, 0, willBeSorted.size - 1)
}

/**
* 取第一个值，中间值，以及最后一个值进行排序。
* 将最大值和最小值分别放在最前和最后。
* 中间值作为标准值，放在倒数第二位。
*/
fun getPivot(array: Array<Int>, left: Int, right: Int): Int {
    val center = (left + right) / 2
    if (array[center] < array[left]) {
        swap(array, center, left)
    }
    if (array[center] > array[right]) {
        swap(array, center, right)
    }
    if (array[left] > array[right]) {
        swap(array, left, right)
    }

    swap(array, center, right - 1)
    return array[right - 1]
}

fun quickSort(willBeSorted: Array<Int>, left: Int, right: Int) {
    if (left >= right) {
        return
    }
    val pivot = getPivot(willBeSorted, left, right)
    // 因为，标准值在倒数第二位，
    // 所以，实质是排序第二位(+1)到倒数第三位(-2)。
    // 但是，start和end不从+1和-2开始，是因为只有2项的情况无法正常排序
    var start = left
    var end = right - 1
    while (start < end) {
        // 是有先++和先--是因为start和end是从已排好序的两项开始比的
        while (willBeSorted[++start] < pivot) {
        }

        while (willBeSorted[--end] > pivot) {
        }

        if (start < end) {
            swap(willBeSorted, start++, end--)
        } else {
            break
        }
    }
    swap(willBeSorted, start, right - 1)

    quickSort(willBeSorted, left, start - 1)
    quickSort(willBeSorted, start + 1, right)
}

fun swap(array: Array<Int>, left: Int, right: Int) {
    val tmp = array[left]
    array[left] = array[right]
    array[right] = tmp
}

