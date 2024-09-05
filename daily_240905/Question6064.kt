package daily_240905

/**
 * 백준 6064번 - 카잉 달력
 */
fun solution6064() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    // 테스트 케이스 T
    val T = br.readLine().toInt()

    repeat(T) {
        val (M, N, x, y) = br.readLine().split(" ").map { it.toInt() }

        var found = false
        var currentYear = x

        while (currentYear <= lcm(M, N)) {
            if ((currentYear - 1) % N + 1 == y) {
                bw.write("$currentYear\n")
                found = true
                break
            }
            currentYear += M
        }

        if (!found) bw.write("-1\n")
    }

    bw.flush()
    bw.close()
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

private fun lcm(a: Int, b: Int): Int {
    return a * (b / gcd(a, b))
}
