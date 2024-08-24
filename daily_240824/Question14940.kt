package daily_240824

import java.util.*

/**
 * 백준 14940번 - 쉬운 최단거리
 */
private data class Point(val n: Int, val m: Int)

fun solution14940() {
    // 상, 하, 좌, 우
    val dn = intArrayOf(1, -1, 0, 0)
    val dm = intArrayOf(0, 0, 1, -1)

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(N) { IntArray(M) }
    val distanceMap = List(N) { IntArray(M) { 0 } }
    val visited = List(N) { BooleanArray(M) { false } }
    val queue: Queue<Point> = LinkedList()

    repeat(N) { n ->
        val row = br.readLine().split(" ").map { it.toInt() }
        map[n] = row.toIntArray()
        repeat(M) { m ->
            // 목표 지점부터 시작
            if (map[n][m] == 2) {
                queue.add(Point(n, m))
                visited[n][m] = true
            }
        }
    }

    fun isNextPointValid(nextN: Int, nextM: Int): Boolean {
        return nextN in 0..<N && nextM in 0..<M &&
                map[nextN][nextM] == 1 &&
                !visited[nextN][nextM]
    }

    while (queue.isNotEmpty()) {
        val (currentN, currentM) = queue.poll()

        // 이동
        for (i in 0..<4) {
            val (nextN, nextM) = currentN + dn[i] to currentM + dm[i]
            if (isNextPointValid(nextN, nextM)) {
                // 다음 탐색 지점 queue add
                queue.add(Point(nextN, nextM))
                // 방문 체크
                visited[nextN][nextM] = true
                // 거리 체크
                distanceMap[nextN][nextM] = distanceMap[currentN][currentM] + 1
            }
        }
    }

    // visited 가 false 인 지역은 distance 를 -1 로 처리해야 함
    for (i in 0..<N) {
        for (j in 0..<M) {
            if (map[i][j] == 1 && !visited[i][j]) distanceMap[i][j] = -1
        }
    }

    distanceMap.forEach { row ->
        for (i in row.indices) bw.write("${row[i]} ")
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}
