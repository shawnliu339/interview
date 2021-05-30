fun main() {
    val array = arrayOf(3, 67, 1, 3, 6, 2)
    quickSort(array)
    array.toList().toString()
}

fun quickSort(willBeSorted: Array<Int>) {
    quickSort(willBeSorted, 0, willBeSorted.size - 1)
}

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
    // start和end不从+1和-2开始，是因为只有2项的情况无法正常排序
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

