package linkedlist

fun main() {
    val list = LinkedList()

    list.insertAtBeginning(10)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    list.insertAtPosition(25, 2)

    list.printList()

    list.deleteAtPosition(1)
    list.printList()

    list.searchElement(30)
    list.searchElement(100)
}
