package daily_240819

/**
 * 백준 2630번 - 색종이 만들기
 */
sealed class Paper {
    data object Blue : Paper()
    data object White : Paper()
}

private val result = mutableListOf<Paper>()

fun solution2630() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // 전체 종이 한 변의 길이 N (2, 4, 8, 16, 32, 64, 128)
    val N = br.readLine().toInt()

    val paper = List(N) {
        br.readLine().split(" ").map { it.toInt() }
    }

    divide(paper, 0, 0, N)

    val blue = result.filterIsInstance<Paper.Blue>().size
    val white = result.filterIsInstance<Paper.White>().size

    bw.write("$white\n$blue")

    bw.flush()
    bw.close()
}

private fun divide(paper: List<List<Int>>, x: Int, y: Int, size: Int) {
    // Size 1 인 종이
    if (size == 1) {
        if (paper[x][y] == 1) result.add(Paper.Blue) else result.add(Paper.White)
        return
    }
    // 모두 같은 색인지 확인
    if (isSameColor(paper, x, y, size)) {
        if (paper[x][y] == 1) result.add(Paper.Blue) else result.add(Paper.White)
        return
    }

    // 4등분
    val half = size / 2
    divide(paper, x, y, half)
    divide(paper, x, y + half, half)
    divide(paper, x + half, y, half)
    divide(paper, x + half, y + half, half)
}

private fun isSameColor(paper: List<List<Int>>, x: Int, y: Int, size: Int): Boolean {
    val color = paper[x][y]
    for (i in x..<x + size) {
        for (j in y..<y + size) {
            if (color != paper[i][j]) return false
        }
    }
    return true
}
