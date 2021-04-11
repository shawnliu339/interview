class MyLinkedList<T> {
    class Node<T>(var value: T?) {
        lateinit var prev: Node<T>
        lateinit var next: Node<T>

        constructor(prev: Node<T>, next: Node<T>, value: T) : this(value) {
            this.prev = prev
            this.next = next
        }
    }

    private lateinit var head: Node<T>
    private lateinit var tail: Node<T>

    private var size: Int = 0

    init {
        clear()
    }

    fun clear() {
        head = Node(null)
        tail = Node(null)
        head.next = tail
        tail.prev = head
    }

    private fun getNode(index: Int): Node<T> {
        if (index < 0 || index > size) {
            throw Exception("Bad")
        }

        return if (index < size / 2) {
            var node = head.next
            for (i in 0 until index) {
                node = node.next
            }
            node
        } else {
            var node = tail
            for (i in size - 1 downTo index) {
                node = node.prev
            }
            node
        }
    }

    fun get(index: Int): T? {
        if (index < 0 || index > size) {
            throw Exception("Bad")
        }
        return getNode(index).value
    }

    fun add(value: T) {
        add(size, value)
    }

    fun add(index: Int, value: T) {
        if (index < 0 || index > size) {
            throw Exception("Bad")
        }

        val target = getNode(index)
        val add = Node(prev = target.prev, next = target, value = value)
        target.prev.next = add
        target.prev = add
        size++
    }

    fun remove(index: Int) {
        if (index < 0 || index >= size || size == 0) {
            throw Exception("bad")
        }
        val target = getNode(index)
        target.prev.next = target.next
        target.next.prev = target.prev
        size--
    }

    override fun toString(): String {
        var node = head
        return buildString {
            append("[")
            append(
                (0 until size).map {
                    node = node.next
                    node.value
                }.joinToString())
            append("]")
        }
    }
}