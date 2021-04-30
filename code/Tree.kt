class MyTree<T : Comparable<T>> {
    private data class TreeNode<T>(
        var left: TreeNode<T>?,
        var right: TreeNode<T>?,
        var value: T
    )

    private var root: TreeNode<T>? = null

    fun insertByLoop(value: T) {
        val willBeInsert = TreeNode(null, null, value)
        if (root == null) {
            root = willBeInsert
            return
        }

        var previous = root
        var current = root
        while (current != null) {
            previous = current
            when {
                value < current.value -> current = current.left
                value == current.value -> return
                value > current.value -> current = current.right
            }
        }

        if (value < previous!!.value) {
            previous.left = willBeInsert
        } else {
            previous.right = willBeInsert
        }
    }

    fun insert(value: T) {
        val willBeInsert = TreeNode(left = null, right = null, value = value)
        if (root == null) {
            root = willBeInsert
        }

        insert(root, willBeInsert)
    }

    private fun insert(target: TreeNode<T>?, willBeInsert: TreeNode<T>): TreeNode<T>? {
        if (target == null) {
            return willBeInsert
        }

        when {
            willBeInsert.value < target.value -> target.left = insert(target.left, willBeInsert)
            willBeInsert.value > target.value -> target.right = insert(target.right, willBeInsert)
        }
        return target
    }

    fun contains(value: T): Boolean {
        if (root == null) {
            return false
        }

        var target = root
        while (target != null) {
            when {
                value < target.value -> target = target.left
                value == target.value -> return true
                value > target.value -> target = target.right
            }
        }
        return false
    }

    fun remove(value: T) {
        remove(root, value)
    }

    private fun remove(target: TreeNode<T>?, value: T): TreeNode<T>? {
        if (target == null) {
            return null
        }

        when {
            value < target.value -> target.left = remove(target.left, value)
            value > target.value -> target.right = remove(target.right, value)
            target.left == null && target.right == null -> return null
            target.left != null && target.right != null -> {
                var min = target.right
                while (min!!.left != null) {
                    min = min.left
                }
                remove(target, min.value)
                target.value = min.value
                return target
            }
            else -> return target.left ?: target.right
        }
        return target
    }

    fun print() {
        if (root == null) {
            return println("Empty Tree")
        }

        val queue = mutableListOf<TreeNode<T>>()
        queue.add(root!!)
        println("Tree start:")
        while (queue.isNotEmpty()) {
            val allValueInOneDepth = queue.map { it.value }.joinToString()
            println(allValueInOneDepth)

            val size = queue.size
            repeat(size) {
                val parent = queue.removeFirst()
                if (parent.left != null) {
                    queue.add(parent.left!!)
                }
                if (parent.right != null) {
                    queue.add(parent.right!!)
                }
            }
        }
        println("Tree end")
    }
}

val tree = MyTree<Int>()
tree.insert(6)
tree.insert(2)
tree.insert(8)
tree.insert(5)
tree.insert(1)
tree.insert(3)
tree.insert(4)

tree.remove(2)

tree.contains(4)
tree.contains(0)
tree.print()