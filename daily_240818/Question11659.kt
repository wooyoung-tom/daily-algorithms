package daily_240818

/**
 * 백준 11659번 - 구간 합 구하기 4
 */
fun solution11659() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // 숫자 개수 N, 합을 구해야 하는 횟수 M
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val arr = br.readLine().split(" ").map { it.toInt() }

    // 누적 합 배열 생성
    val prefixSum = IntArray(N + 1)
    for (i in 1..N) {
        prefixSum[i] = prefixSum[i - 1] + arr[i - 1]
    }

    repeat(M) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        // 구간 합 계산: prefixSum[j] - prefixSum[i - 1]
        bw.write("${prefixSum[j] - prefixSum[i - 1]}\n")
    }

    bw.flush()
    bw.close()
}
