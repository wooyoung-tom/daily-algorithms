package daily_240820

import java.util.*

/**
 * 백준 11724번 - 연결 요소의 개수
 */
fun solution11724() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // 전체 노드의 개수 N, 간선의 개수 M
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val graph = List(N + 1) { IntArray(N + 1) }

    repeat(M) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }

        graph[u][v] = 1
        graph[v][u] = 1
    }

    val visited = BooleanArray(N + 1)
    var result = 0

    for (i in 1..N) {
        if (!visited[i]) {
            bfs(graph, visited, i)
            result++
        }
    }

    bw.write("$result")

    bw.flush()
    bw.close()
}

private fun bfs(graph: List<IntArray>, visited: BooleanArray, start: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (i in 1..<graph.size) {
            if (graph[cur][i] == 1 && !visited[i]) {
                queue.add(i)
                visited[i] = true
            }
        }
    }
}
