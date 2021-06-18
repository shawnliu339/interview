val i = 0
val parent = (i - 1) / 2
val left = 2 * i + 1
val right = 2 * i + 2

fun adjust(array: Array<Int>, leftOrRightIndex: Int) {
    if (leftOrRightIndex < 0) {
        return
    }
    val parentIndex = (leftOrRightIndex - 1) / 2
    val leftIndex = 2 * parentIndex + 1
    val rightIndex = 2 * parentIndex + 2

    if (leftIndex < array.size && array[parentIndex] < array[leftIndex]) {
        swap(array, parentIndex, leftIndex)
    }

    if (rightIndex < array.size && array[parentIndex] < array[rightIndex]) {
        swap(array, parentIndex, rightIndex)
    }

    adjust(array, leftOrRightIndex - 2)
}

fun swap(array: Array<Int>, left: Int, right: Int) {
    val tmp = array[left]
    array[left] = array[right]
    array[right] = tmp
}