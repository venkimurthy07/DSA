package trees

fun main() {
    val tree = BinaryTree()

    tree.insert(10)
    tree.insert(5)
    tree.insert(15)
    tree.insert(3)
    tree.insert(7)

    print("Inorder: ")
    tree.inOrder(tree.root)
    println()

    print("Preorder: ")
    tree.preOrder(tree.root)
    println()

    print("Postorder: ")
    tree.postOrder(tree.root)
    println()

    print("Level Order: ")
    tree.levelOrder()

    println("\nSearch 7: ${tree.search(tree.root, 7)}")
}

class BinaryTree {

    var root: Node? = null

    class Node(val data: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    // Insert (Level Order)
    fun insert(data: Int) {
        val newNode = Node(data)

        if (root == null) {
            root = newNode
            return
        }

        val queue = ArrayDeque<Node>()
        queue.add(root!!)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            if (current.left == null) {
                current.left = newNode
                return
            } else queue.add(current.left!!)

            if (current.right == null) {
                current.right = newNode
                return
            } else queue.add(current.right!!)
        }
    }

    // Inorder (LNR)
    fun inOrder(node: Node?) {
        if (node == null) return
        inOrder(node.left)
        print("${node.data} ")
        inOrder(node.right)
    }

    // Preorder (NLR)
    fun preOrder(node: Node?) {
        if (node == null) return
        print("${node.data} ")
        preOrder(node.left)
        preOrder(node.right)
    }

    // Postorder (LRN)
    fun postOrder(node: Node?) {
        if (node == null) return
        postOrder(node.left)
        postOrder(node.right)
        print("${node.data} ")
    }

    // Level Order (BFS)
    fun levelOrder() {
        if (root == null) return

        val queue = ArrayDeque<Node>()
        queue.add(root!!)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            print("${node.data} ")

            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
    }

    //  Search
    fun search(node: Node?, key: Int): Boolean {
        if (node == null) return false
        if (node.data == key) return true
        return search(node.left, key) || search(node.right, key)
    }
}
