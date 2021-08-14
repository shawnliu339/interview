fun quickSort(array: Array<Int>, left: Int, right: Int) {
    if (left >= right) {
        return
    }

    val pivot = array[left]
    swap(array, left, right)

    var start = left
    var end = right - 1

    while (start <= end) {
        // 如果没有等于，[1, 1, 1, 9]无法正常排序
        while (start <= end && array[start] < pivot) {
            start++
        }
        while (start <= end && array[end] > pivot) {
            end--
        }
        if (start < end) {
            swap(array, start++, end--)
        }
    }

    swap(array, start, right)
    quickSort(array, left, start - 1)
    quickSort(array, start + 1, right)
}

fun swap(array: Array<Int>, left: Int, right: Int) {
    val tmp = array[left]
    array[left] = array[right]
    array[right] = tmp
}

fun quickSort(array: Array<Int>) {
    quickSort(array, 0, array.size - 1)
}

val testCase = arrayOf(1, 6, 4, 3, 9, 6, 1)
quickSort(testCase)
testCase.toList().toString()