package daily_240909

import java.util.*

/**
 * 프로그래머스 - 배달
 * 난 dp로 구현했는데 다익스트라도 있나?
 */
class Delivery {
    // solution by DP
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val dp = IntArray(N + 1) { Int.MAX_VALUE }

        dp[1] = 0

        val queue: Queue<Int> = LinkedList()
        queue.add(1)

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            road.filter { (u, v, _) -> u == current || v == current }
                .forEach { (u, v, w) ->
                    val next = if (u == current) v else u
                    if (dp[next] > dp[current] + w) {
                        dp[next] = dp[current] + w
                        queue.add(next)
                    }
                }
        }

        return dp.count { it <= k }
    }

    // solution by Dijkstra
    fun solution2(N: Int, road: Array<IntArray>, k: Int): Int {
        val adj = Array(N + 1) { mutableListOf<Pair<Int, Int>>() }
        road.forEach { (u, v, w) ->
            adj[u].add(v to w)
            adj[v].add(u to w)
        }

        val dp = IntArray(N + 1) { Int.MAX_VALUE }
        dp[1] = 0

        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.add(1 to 0)

        while (pq.isNotEmpty()) {
            val (current, dist) = pq.poll()

            if (dp[current] < dist) continue

            for ((next, weight) in adj[current]) {
                val nextDist = dist + weight
                if (nextDist < dp[next]) {
                    dp[next] = nextDist
                    pq.add(next to nextDist)
                }
            }
        }

        return dp.count { it <= k }
    }
}