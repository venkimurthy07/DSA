package stacks

fun main() {
    //LIFO
    val stack = StackArray(5)

    stack.push(10)
    stack.push(20)
    stack.push(30)

    stack.printStack()

    stack.pop()
    stack.printStack()

    println("Peek: ${stack.peek()}")
}

class StackArray(private val size: Int) {

    private val stack = IntArray(size)
    private var top = -1

    // Push – O(1)
    fun push(value: Int) {
        if (top == size - 1) {
            println("Stack Overflow")
            return
        }
        stack[++top] = value
    }

    // Pop – O(1)
    fun pop(): Int? {
        if (top == -1) {
            println("Stack Underflow")
            return null
        }
        return stack[top--]
    }

    // Peek – O(1)
    fun peek(): Int? {
        return if (top == -1) null else stack[top]
    }

    // isEmpty
    fun isEmpty(): Boolean {
        return top == -1
    }

    // Print Stack
    fun printStack() {
        print("Stack (bottom -> top): ")
        for (i in 0..top) {
            print("${stack[i]} ")
        }
        println()
    }
}
