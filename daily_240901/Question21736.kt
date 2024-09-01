package daily_240901

import java.util.*

/**
 * 백준 21736번 - 헌내기는 친구가 필요해
 */
fun solution21736() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    data class Point(val n: Int, val m: Int)

    // 이동
    val dn = intArrayOf(1, -1, 0, 0)
    val dm = intArrayOf(0, 0, 1, -1)

    // size of campus
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val campus: List<List<String>> = List(N) {
        br.readLine().toList().map { it.toString() }
    }

    val queue: Queue<Point> = LinkedList()
    val visited: List<BooleanArray> = List(N) { BooleanArray(M) { false } }

    fun movable(n: Int, m: Int): Boolean {
        return n in 0..<N && m in 0..<M && !visited[n][m] && campus[n][m] != "X"
    }

    // 처음 시작할 곳 찾아야 함
    for (n in 0..<N) {
        for (m in 0..<M) {
            if (campus[n][m] == "I") {
                queue.add(Point(n, m))
                visited[n][m] = true
            }
        }
    }

    var friends = 0

    while (queue.isNotEmpty()) {
        val (currentN, currentM) = queue.poll()

        for (i in 0..<4) {
            val nextN = currentN + dn[i]
            val nextM = currentM + dm[i]

            if (movable(nextN, nextM)) {
                queue.add(Point(nextN, nextM))

                visited[nextN][nextM] = true

                if (campus[nextN][nextM] == "P") friends++
            }
        }
    }

    if (friends == 0) {
        bw.write("TT\n")
    } else {
        bw.write("$friends")
    }

    bw.flush()
    bw.close()
}
