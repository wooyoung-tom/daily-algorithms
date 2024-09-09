package daily_240909

/**
 * 프로그래머스 - 등대
 * dfs 랑 dp 를 같이 사용하네?
 */
class Lighthouse {
    fun solution(n: Int, lighthouse: Array<IntArray>): Int {
        // 인접 리스트 생성
        val adj = Array(n + 1) { mutableListOf<Int>() }
        lighthouse.forEach { (u, v) ->
            adj[u].add(v)
            adj[v].add(u)
        }

        // dp 배열 생성
        val dp = Array(n + 1) { IntArray(2) }
        val visited = BooleanArray(n + 1)

        fun dfs(node: Int) {
            visited[node] = true
            dp[node][0] = 0  // 노드가 꺼져 있을 때
            dp[node][1] = 1  // 노드가 켜져 있을 때

            for (neighbor in adj[node]) {
                if (!visited[neighbor]) {
                    dfs(neighbor)

                    // 자식 노드가 꺼져 있을 때, 현재 노드는 켜져야 함
                    dp[node][0] += dp[neighbor][1]

                    // 현재 노드가 켜져 있을 때는 자식 노드가 꺼지거나 켜질 수 있음
                    dp[node][1] += minOf(dp[neighbor][0], dp[neighbor][1])
                }
            }
        }

        // 루트 노드를 1로 가정하고 DFS 시작
        dfs(1)

        // 결과는 루트 노드가 꺼져 있거나 켜져 있을 때의 최소값
        return minOf(dp[1][0], dp[1][1])
    }
}