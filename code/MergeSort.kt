fun mergeSort(array: Array<Int>) {
    mergeSort(
        origin = array,
        tmpArray = array.copyOf(),
        startIndex = 0,
        endIndex = array.size - 1)
}

fun mergeSort(
    origin: Array<Int>,
    tmpArray: Array<Int>,
    startIndex: Int,
    endIndex: Int
) {
    val length = endIndex - startIndex + 1
    if (length == 1) {
        return
    }

    // Very important here
    val centerIndex = (endIndex + startIndex) / 2
    mergeSort(
        origin = origin,
        tmpArray = tmpArray,
        startIndex = startIndex,
        endIndex = centerIndex
    )

    val rightStart = centerIndex + 1
    mergeSort(
        origin = origin,
        tmpArray = tmpArray,
        startIndex = rightStart,
        endIndex = endIndex
    )

    var tmpPosition = startIndex
    var leftPosition = startIndex
    var rightPosition = rightStart
    // 需要有等于，因为，左右指针相等时，相当于数组中还剩最后一个元素，仍需要进行比较。
    while (leftPosition <= centerIndex && rightPosition <= endIndex) {
        if (origin[leftPosition] < origin[rightPosition]) {
            tmpArray[tmpPosition++] = origin[leftPosition++]
        } else {
            tmpArray[tmpPosition++] = origin[rightPosition++]
        }
    }

    while (leftPosition <= centerIndex) {
        tmpArray[tmpPosition++] = origin[leftPosition++]
    }

    while (rightPosition <= endIndex) {
        tmpArray[tmpPosition++] = origin[rightPosition++]
    }

    // copy to original array
    for (i in startIndex..endIndex) {
        origin[i] = tmpArray[i]
    }
}

fun main() {
    val array = arrayOf(3, 2, 5, 1, 2)
    mergeSort(array)
    println(array.toList())
}