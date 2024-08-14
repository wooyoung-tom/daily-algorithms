package daily_240815

/**
 * 프로그래머스 - 네트워크
 */
class Network {
    private val visited = mutableListOf<Boolean>()

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        visited.addAll(List(n) { false })

        for (i in computers.indices) {
            if (!visited[i]) dfs(computers, i).also { answer++ }
        }

        return answer
    }

    private fun dfs(computers: Array<IntArray>, i: Int) {
        visited[i] = true

        computers[i].forEachIndexed { j, connected ->
            if (connected == 1 && !visited[j]) dfs(computers, j)
        }
    }
}