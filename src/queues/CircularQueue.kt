package queues

class CircularQueue(private val size: Int) {

    private val queue = IntArray(size)
    private var front = 0
    private var rear = -1
    private var count = 0

    fun enqueue(value: Int) {
        if (count == size) {
            println("Queue Overflow")
            return
        }
        rear = (rear + 1) % size
        queue[rear] = value
        count++
    }

    fun dequeue(): Int? {
        if (count == 0) {
            println("Queue Underflow")
            return null
        }
        val value = queue[front]
        front = (front + 1) % size
        count--
        return value
    }

    fun peek(): Int? {
        return if (count == 0) null else queue[front]
    }

    fun printQueue() {
        print("Circular Queue: ")
        for (i in 0 until count) {
            print("${queue[(front + i) % size]} ")
        }
        println()
    }
}
