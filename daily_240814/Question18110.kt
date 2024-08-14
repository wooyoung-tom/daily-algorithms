package daily_240814

import kotlin.math.roundToInt

/**
 * 백준 18110번 - solved.ac
 */
fun solution18110() {
    // 난이도 의견의 개수
    val n = readln().toInt()
    // 난이도 의견 리스트
    val opinions = IntArray(n)
    repeat(n) { opinions[it] = readln().toInt() }

    // 난이도 의견의 개수가 0이면 0 출력
    if (opinions.isEmpty()) return println(0)

    // 제외할 인원 수
    val except = (n * 0.15).roundToInt()

    // 제외할 인원 수만큼 난이도 의견을 제외하고 평균을 구한다.
    val result = opinions
        .sorted()
        .drop(except)
        .dropLast(except)
        .average()
        .roundToInt()

    println(result)
}
