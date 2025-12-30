package graphs


fun main() {
    val graph = Graph(5)

    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 4)

    print("BFS: ")
    graph.bfs(0)

    print("\nDFS: ")
    graph.dfs(0)
}

class Graph(private val vertices: Int) {

    private val adjList = Array(vertices) { mutableListOf<Int>() }

    // Add Edge (Undirected)
    fun addEdge(src: Int, dest: Int) {
        adjList[src].add(dest)
        adjList[dest].add(src)
    }

    // BFS (Queue)
    fun bfs(start: Int) {
        val visited = BooleanArray(vertices)
        val queue = ArrayDeque<Int>()

        visited[start] = true
        queue.add(start)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            print("$node ")

            for (neighbor in adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true
                    queue.add(neighbor)
                }
            }
        }
    }

    // DFS (Recursion)
    fun dfs(start: Int) {
        val visited = BooleanArray(vertices)
        dfsUtil(start, visited)
    }

    private fun dfsUtil(node: Int, visited: BooleanArray) {
        visited[node] = true
        print("$node ")

        for (neighbor in adjList[node]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited)
            }
        }
    }
}
