package daily_240901

import kotlin.math.max

/**
 * 백준 18111번 - 마인크래프트
 */
fun solution18111() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (N, _, B) = br.readLine().split(" ").map { it.toInt() }

    val ground: List<List<Int>> = List(N) {
        br.readLine().split(" ").map { it.toInt() }
    }

    val minHeight = ground.flatten().min()
    val maxHeight = ground.flatten().max()

    var minTime = Int.MAX_VALUE
    var groundHeight = 0

    for (height in minHeight..maxHeight) {
        var removed = 0
        var added = 0

        for (row in ground) {
            for (cell in row) {
                if (cell > height) removed += cell - height
                else if (cell < height) added += height - cell
                else continue
            }
        }

        if (removed + B >= added) {
            val time = removed * 2 + added * 1
            if (time <= minTime) {
                minTime = time
                groundHeight = height
            }
        }
    }

    bw.write("$minTime $groundHeight")

    bw.flush()
    bw.close()
}
