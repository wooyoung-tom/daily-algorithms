package daily_240830

import kotlin.math.min
import kotlin.math.sqrt

/**
 * 백준 17626번 - Four Squares
 */
fun solution17626() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // 자연수 N
    val N = br.readLine().toInt()

    // dp 배열 초기화
    val dp = IntArray(N + 1) { it }

    // dp 배열 채우기
    for (i in 1..N) {
        for (j in 1..sqrt(i.toDouble()).toInt()) {
            dp[i] = min(dp[i], dp[i - j * j] + 1)
        }
    }

    // 결과 출력
    bw.write("${dp[N]}")

    bw.flush()
    bw.close()
}
