package linkedlist

class LinkedList {

    private var head: Node? = null

    // Node definition
    class Node(val data: Int) {
        var next: Node? = null
    }

    // Insert at Beginning
    fun insertAtBeginning(data: Int) {
        val newNode = Node(data)
        newNode.next = head
        head = newNode
    }

    // Insert at End
    fun insertAtEnd(data: Int) {
        val newNode = Node(data)

        if (head == null) {
            head = newNode
            return
        }

        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = newNode
    }

    // Insert at Particular Position
    fun insertAtPosition(data: Int, pos: Int) {
        if (pos < 0) {
            println("Invalid position")
            return
        }

        if (pos == 0) {
            insertAtBeginning(data)
            return
        }

        var current = head
        var index = 0

        while (current != null && index < pos - 1) {
            current = current.next
            index++
        }

        if (current == null) {
            println("Position out of bounds")
            return
        }

        val newNode = Node(data)
        newNode.next = current.next
        current.next = newNode
    }

    // Delete from Particular Position
    fun deleteAtPosition(pos: Int) {
        if (head == null || pos < 0) {
            println("Invalid position")
            return
        }

        if (pos == 0) {
            head = head?.next
            return
        }

        var current = head
        var index = 0

        while (current?.next != null && index < pos - 1) {
            current = current.next
            index++
        }

        if (current?.next == null) {
            println("Position out of bounds")
            return
        }

        current.next = current.next?.next
    }

    // Search Element
    fun searchElement(data: Int) {
        var current = head
        var index = 0

        while (current != null) {
            if (current.data == data) {
                println("Element $data found at index $index")
                return
            }
            current = current.next
            index++
        }
        println("Element $data not found")
    }

    // Print Linked List
    fun printList() {
        var current = head
        print("LinkedList: ")
        while (current != null) {
            print("${current.data} -> ")
            current = current.next
        }
        println("null")
    }
}
