package queues

fun main() {
    val queue = QueueArray(5)

    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)

    queue.printQueue()

    queue.dequeue()
    queue.printQueue()

    println("Front: ${queue.peek()}")
}

class QueueArray(private val size: Int) {

    private val queue = IntArray(size)
    private var front = 0
    private var rear = -1
    private var count = 0

    //Enqueue – O(1)
    fun enqueue(value: Int) {
        if (count == size) {
            println("Queue Overflow")
            return
        }
        rear++
        queue[rear] = value
        count++
    }

    // Dequeue – O(1)
    fun dequeue(): Int? {
        if (count == 0) {
            println("Queue Underflow")
            return null
        }
        val value = queue[front]
        front++
        count--
        return value
    }

    // Peek
    fun peek(): Int? {
        return if (count == 0) null else queue[front]
    }

    // isEmpty
    fun isEmpty(): Boolean {
        return count == 0
    }

    // Print Queue
    fun printQueue() {
        print("Queue (front -> rear): ")
        for (i in front..rear) {
            print("${queue[i]} ")
        }
        println()
    }
}
