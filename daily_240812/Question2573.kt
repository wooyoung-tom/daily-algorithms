package daily_240812

/**
 * 백준 2573번. 빙산
 */
import java.util.*

data class Point(val x: Int, val y: Int)

fun solution2573() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val iceberg = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val directions = arrayOf(
        Point(1, 0), Point(-1, 0), Point(0, 1), Point(0, -1)
    )

    var year = 0
    while (true) {
        val visited = Array(n) { BooleanArray(m) }
        var components = 0

        for (i in 0..<n) {
            for (j in 0..<m) {
                if (iceberg[i][j] > 0 && !visited[i][j]) {
                    components++
                    bfs(iceberg, visited, Point(i, j), n, m, directions)
                }
            }
        }

        if (components > 1) {
            println(year)
            return
        }

        if (components == 0) {
            println(0)
            return
        }

        meltIceberg(iceberg, n, m, directions)
        year++
    }
}

fun bfs(
    iceberg: Array<IntArray>,
    visited: Array<BooleanArray>,
    start: Point,
    n: Int,
    m: Int,
    directions: Array<Point>
) {
    val queue: Queue<Point> = LinkedList()
    queue.add(start)
    visited[start.x][start.y] = true

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        for (dir in directions) {
            val nx = current.x + dir.x
            val ny = current.y + dir.y
            if (nx in 0..<n && ny in 0..<m && !visited[nx][ny] && iceberg[nx][ny] > 0) {
                visited[nx][ny] = true
                queue.add(Point(nx, ny))
            }
        }
    }
}

fun meltIceberg(iceberg: Array<IntArray>, n: Int, m: Int, directions: Array<Point>) {
    val meltAmount = Array(n) { IntArray(m) }

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (iceberg[i][j] > 0) {
                for (dir in directions) {
                    val nx = i + dir.x
                    val ny = j + dir.y
                    if (nx in 0..<n && ny in 0..<m && iceberg[nx][ny] == 0) {
                        meltAmount[i][j]++
                    }
                }
            }
        }
    }

    for (i in 0..<n) {
        for (j in 0..<m) {
            iceberg[i][j] = (iceberg[i][j] - meltAmount[i][j]).coerceAtLeast(0)
        }
    }
}