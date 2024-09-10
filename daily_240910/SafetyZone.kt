package daily_240910

class SafetyZone {
    private data class Point(val x: Int, val y: Int)

    fun solution(board: Array<IntArray>): Int {
        val n = board.size

        val bombs = mutableListOf<Point>()
        val map = Array(n) { IntArray(n) { 0 } }

        // 8방향
        val dx = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
        val dy = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

        for (x in 0 until n) {
            for (y in 0 until n) {
                if (board[x][y] == 1) bombs.add(Point(x, y))
            }
        }

        bombs.forEach {
            val (x, y) = it

            // 폭탄 있으면 안전지대가 아님
            map[x][y] = -1

            for (i in 0 until 8) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue

                // 폭탄 주위 모두 안전지대가 아님
                map[nx][ny] = -1
            }
        }

        return map.flatMap { it.toList() }.count { it == 0 }
    }
}