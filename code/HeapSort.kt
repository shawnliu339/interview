val i = 0
val parent = (i - 1) / 2
val left = 2 * i + 1
val right = 2 * i + 2

fun adjust(array: Array<Int>, length: Int, index: Int) {
    if (index >= length) {
        return
    }
    val leftIndex = 2 * index + 1
    val rightIndex = 2 * index + 2

    var max = index
    if (leftIndex < length && array[max] < array[leftIndex]) {
        max = leftIndex
    }

    if (rightIndex < length && array[max] < array[rightIndex]) {
        max = rightIndex
    }

    if (max != index) {
        swap(array, index, max)
        adjust(array, length, max)
    }
}

fun buildMaxHeap(array: Array<Int>) {
    val parent = (array.lastIndex - 1) / 2
    for (i in parent downTo 0) {
        adjust(array, array.size, i)
    }
}

fun heapSort(array: Array<Int>) {
    buildMaxHeap(array)

    for (i in array.lastIndex downTo 1) {
        swap(array, 0, i)
        adjust(array, i, 0)
    }
}

fun swap(array: Array<Int>, left: Int, right: Int) {
    val tmp = array[left]
    array[left] = array[right]
    array[right] = tmp
}

val array = arrayOf(2, 5, 3, 1, 10, 4)
heapSort(array)
array.toList()
