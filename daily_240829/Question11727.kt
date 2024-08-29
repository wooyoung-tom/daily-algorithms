package daily_240829

/**
 * 백준 11727번 - 2xn 타일링 2
 */
fun solution11727() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    val N = br.readLine().toInt()

    val dp = IntArray(N + 1)

    dp[1] = 1
    if (N >= 2) dp[2] = 3

    for (i in 3..N) {
        dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007
    }

    bw.write("${dp[N]}\n")

    bw.flush()
    bw.close()
}
