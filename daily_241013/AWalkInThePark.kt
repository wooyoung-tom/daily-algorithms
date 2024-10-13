package daily_241013

/**
 * 프로그래머스 - 공원 산책
 */
class AWalkInThePark {
    private data class Point(val i: Int, val j: Int)

    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val fullCommands: List<List<String>> = park.map {
            it.split("").filter { command -> command.isNotBlank() }
        }

        var current = Point(0, 0)

        fullCommands.forEachIndexed { i, commands ->
            commands.forEachIndexed { j, command ->
                if (command == "S") current = Point(i, j)
            }
        }

        for (route in routes) {
            val (op, n) = route.split(" ")

            val next = when (op) {
                "E" -> Point(current.i, current.j + n.toInt())
                "W" -> Point(current.i, current.j - n.toInt())
                "S" -> Point(current.i + n.toInt(), current.j)
                "N" -> Point(current.i - n.toInt(), current.j)
                else -> current
            }

            // 일단 next 가 범위 안에 있는지 확인
            if (next.i < 0 || next.i >= fullCommands.size) continue
            if (next.j < 0 || next.j >= fullCommands[next.i].size) continue

            // current 에서 next 까지 가면서 장애물 있으면 못감
            var isBlocked = false
            if (current.i > next.i) {
                for (i in next.i .. current.i) {
                    if (fullCommands[i][current.j] == "X") isBlocked = true
                }
            } else if (current.i < next.i) {
                for (i in current.i .. next.i) {
                    if (fullCommands[i][current.j] == "X") isBlocked = true
                }
            } else if (current.j > next.j) {
                for (j in next.j .. current.j) {
                    if (fullCommands[current.i][j] == "X") isBlocked = true
                }
            } else if (current.j < next.j) {
                for (j in current.j .. next.j) {
                    if (fullCommands[current.i][j] == "X") isBlocked = true
                }
            }
            if (isBlocked) continue else current = next
        }

        return current.run { intArrayOf(i, j) }
    }
}