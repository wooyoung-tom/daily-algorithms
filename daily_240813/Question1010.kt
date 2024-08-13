package daily_240813

/**
 * 백준 1010번. 다리 놓기
 * factorial
 */
fun solution1010() {
    val T = readln().toInt()
    repeat(T) {
        // 강 서쪽 사이트 N 개, 동쪽 사이트 M 개
        val (N, M) = readln().split(" ").map { it.toInt() }
        var result = 1
        for (i in 1..N) result = result * (M - i + 1) / i
    }
}
