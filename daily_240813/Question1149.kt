package daily_240813

import kotlin.math.min

/**
 * 백준 1149번. RGB거리
 */
fun solution1149() {
    val N = readln().toInt()
    // 각 집을 칠하는 비용을 저장할 배열 (빨, 초, 파)
    val cost = List(N) { readln().split(" ").map { it.toInt() } }
    // 각 집을 칠하는 비용의 최솟값을 저장할 배열 (빨, 초, 파)
    val dp = Array(N) { IntArray(3) }

    // 첫 번째 집을 칠하는 비용은 그대로 저장
    dp[0] = cost[0].toIntArray()

    // 두 번째 집부터 N번째 집까지
    for (i in 1..<N) {
        // 빨간색을 칠할 경우
        dp[i][0] = cost[i][0] + min(dp[i - 1][1], dp[i - 1][2])
        // 초록색을 칠할 경우
        dp[i][1] = cost[i][1] + min(dp[i - 1][0], dp[i - 1][2])
        // 파란색을 칠할 경우
        dp[i][2] = cost[i][2] + min(dp[i - 1][0], dp[i - 1][1])
    }

    // N번째 집을 칠하는 비용의 최솟값을 출력
    dp[N - 1].min().let(::println)
}