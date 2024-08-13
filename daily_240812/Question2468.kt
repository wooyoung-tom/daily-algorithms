package daily_240812

/**
 * 2468. 안전 영역
 */
fun solution2468() {
    val N = readln().toInt()
    // make N x N map
    val map = List(N) { readln().split(" ").map { it.toInt() } }
    // get max height
    val maxHeight = map.flatten().maxOrNull() ?: 100
    // get max safe area
    var maxSafeArea = 1
    // 강수량 1부터 최대 높이까지 반복
    for (precipitation in 1..maxHeight) {
        // 강수량 한 번마다 방문 여부 초기화
        val visited = Array(N) { BooleanArray(N) }
        // 현재 강수량에서 안전 영역의 개수
        var safeArea = 0

        for (i in 0..<N) {
            for (j in 0..<N) {
                if (map[i][j] > precipitation && !visited[i][j]) {
                    safeArea++
                    dfs(map, visited, i, j, precipitation)
                }
            }
        }

        maxSafeArea = maxOf(maxSafeArea, safeArea)
    }
    println(maxSafeArea)
}

private fun dfs(
    map: List<List<Int>>,
    visited: Array<BooleanArray>,
    x: Int,
    y: Int,
    currentPrecipitation: Int,
) {
    if (x < 0 || x >= map.size || y < 0 || y >= map.size) return
    if (map[x][y] <= currentPrecipitation || visited[x][y]) return
    visited[x][y] = true
    dfs(map, visited, x - 1, y, currentPrecipitation)
    dfs(map, visited, x + 1, y, currentPrecipitation)
    dfs(map, visited, x, y - 1, currentPrecipitation)
    dfs(map, visited, x, y + 1, currentPrecipitation)
}
