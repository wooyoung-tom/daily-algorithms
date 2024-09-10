package daily_240910

import java.util.*

/**
 * 프로그래머스 - 미로 탈출
 * 지도가 직사각형일 수 있다는 점을 간과함
 */
class MazeEscaping {
    private data class Point(val n: Int, val m: Int)

    // 상하좌우
    private val dn = intArrayOf(-1, 1, 0, 0)
    private val dm = intArrayOf(0, 0, -1, 1)

    private val queue: Queue<Point> = LinkedList()

    private var time = 0

    fun solution(maps: Array<String>): Int {
        val map = maps.map { string ->
            string.split("").filter { it.isNotBlank() }
        }

        val (n, m) = map.size to map[0].size

        val visited = List(n) { BooleanArray(m) { false } }

        // 시작점 설정
        val start = map.findStart() ?: return -1
        visited[start.n][start.m] = true
        queue.add(start)

        if (!map.find(visited, "L")) return -1

        // 다시 방문 초기화
        visited.forEach { it.fill(false) }

        if (!map.find(visited, "E")) return -1

        return time
    }

    private fun List<List<String>>.findStart(): Point? {
        val (N, M) = this.size to this[0].size
        for (n in 0 until N) {
            for (m in 0 until M) {
                if (this[n][m] == "S") return Point(n, m)
            }
        }
        return null
    }

    private fun List<List<String>>.find(visited: List<BooleanArray>, target: String): Boolean {
        val (N, M) = this.size to this[0].size
        while (queue.isNotEmpty()) {
            // 현재 queue 사이즈 만큼 도는 것이 1초
            for (i in 0 until queue.size) {
                val (n, m) = queue.poll()

                if (this[n][m] == target) {
                    queue.clear()
                    queue.add(Point(n, m))
                    return true
                }

                for (i in 0 until 4) {
                    val nn = n + dn[i]
                    val nm = m + dm[i]

                    if (nn < 0 || nn >= N || nm < 0 || nm >= M) continue
                    if (this[nn][nm] == "X" || visited[nn][nm]) continue
                    visited[nn][nm] = true
                    queue.add(Point(nn, nm))
                }
            }
            time++
        }
        return false
    }
}