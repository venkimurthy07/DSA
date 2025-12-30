package arrays

fun main() {
    val array = arrayOf(10, 20, 30, 40)

    val ops = ArraysOperations()

    ops.insertAtBeginning(array, 5)
    ops.insertAtEnd(array, 50)
    ops.insertAtPosition(array, 25, 2)
    ops.deleteAtPosition(array, 1)
    ops.searchElement(array, 30)
}

class ArraysOperations {

    // Insert at Beginning
    fun insertAtBeginning(array: Array<Int>, element: Int) {
        val result = Array(array.size + 1) { 0 }

        result[0] = element
        for (i in array.indices) {
            result[i + 1] = array[i]
        }

        print("Insert at beginning: ")
        printArray(result)
    }

    // Insert at End
    fun insertAtEnd(array: Array<Int>, element: Int) {
        val result = Array(array.size + 1) { 0 }

        for (i in array.indices) {
            result[i] = array[i]
        }
        result[array.size] = element

        print("Insert at end: ")
        printArray(result)
    }

    // Insert at Particular Position
    fun insertAtPosition(array: Array<Int>, element: Int, pos: Int) {
        if (pos < 0 || pos > array.size) {
            println("Invalid position")
            return
        }

        val result = Array(array.size + 1) { 0 }

        for (i in 0 until pos) {
            result[i] = array[i]
        }

        result[pos] = element

        for (i in pos until array.size) {
            result[i + 1] = array[i]
        }

        print("Insert at position $pos: ")
        printArray(result)
    }

    // Delete from Particular Position
    fun deleteAtPosition(array: Array<Int>, pos: Int) {
        if (pos < 0 || pos >= array.size) {
            println("Invalid position")
            return
        }

        val result = Array(array.size - 1) { 0 }

        for (i in 0 until pos) {
            result[i] = array[i]
        }

        for (i in pos + 1 until array.size) {
            result[i - 1] = array[i]
        }

        print("Delete at position $pos: ")
        printArray(result)
    }

    // Search Element
    fun searchElement(array: Array<Int>, element: Int) {
        for (i in array.indices) {
            if (array[i] == element) {
                println("Element $element found at index $i")
                return
            }
        }
        println("Element $element not found")
    }

    // Utility function
    private fun printArray(array: Array<Int>) {
        for (i in array) {
            print("$i ")
        }
        println()
    }
}
