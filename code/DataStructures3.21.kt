import java.util.LinkedList

match(listOf("/*", "(", ")", "[", "(", ")", "*/"))

fun match(list: List<String>) {
    val stack = LinkedList<String>()
    list.forEach {
        if (it == "/*" || it == "(" || it == "[" || it == "{") {
            stack.push(it)
            return@forEach
        }

        if (stack.size == 0) {
            println("The $it can not match any symbol")
            return
        }

        val left = stack.pop()
        val expectRight = getExpectRight(left)
        if (expectRight != it) {
            println("The ${stack.size} $left can not match with $it. Maybe lack of symbol")
            return
        }
    }

    if (stack.isNotEmpty()) {
        println("The ${stack.peekLast()} can not match with any symbol.")
        return
    }

    println("Match!!!")
}

fun getExpectRight(left: String): String {
    return when (left) {
        "/*" -> "*/"
        "(" -> ")"
        "[" -> "]"
        "{" -> "}"
        else -> throw Exception("$left can not match any symbol.")
    }
}

