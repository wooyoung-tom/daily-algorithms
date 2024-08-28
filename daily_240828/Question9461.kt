package daily_240828

/**
 * 백준 9461번 - 파도반 수열
 * 진짜 단순 규칙 찾기.
 */
fun solution9461() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // TC
    val T = br.readLine().toInt()

    fun solve() {
        val N = br.readLine().toInt()

        val dp = LongArray(N + 1)
        dp[1] = 1
        if (N >= 2) dp[2] = 1
        if (N >= 3) dp[3] = 1
        if (N >= 4) dp[4] = 2
        if (N >= 5) dp[5] = 2

        for (i in 6..N) {
            dp[i] = dp[i - 1] + dp[i - 5]
        }

        bw.write("${dp[N]}\n")

        bw.flush()
    }

    repeat(T) {
        solve()
    }

    bw.close()
}
