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
    /*
    while (parentIndex >= 0) {
        adjust(array, parentIndex, array.lastIndex)
        parentIndex = (parentIndex - 1) / 2
    }
    以上写法不正确：
    1. 会出现死循环：(0 - 1)/2值为0而不为-0.5
    2. 无法对整个树进行遍历，因此，无法找到最大值。
       例如：测试用例中右侧分支的100(index=5)无法被放置堆顶。
     */
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

val array = arrayOf(81, 94, 11, 96, 12, 100, 17, 95)
heapSort(array)
array.toList()

/**
 * 该错误示范为双循环n^2的复杂度，所以，不正确。
 * 仅仅做到了形似大顶堆， 但是，并没有实现大顶堆的本质，
 * 即在建立起大顶堆后，只有树中的变动分支才需重新排序。
 * 正是因为只有变动分支才需要重新排列，
 * 所以，heap sort的时间复杂度为nlog(n)。
 */
fun incorrectHeapSort(array: Array<Int>) {
    for (i in array.lastIndex downTo 0) {
        var j = i
        while (j>0) {
            val parent = (j - 1) / 2
            if (array[parent] < array[j]) {
                swap(array, parent, j)
            }
            j--
        }
        swap(array, 0, i)
    }
}
