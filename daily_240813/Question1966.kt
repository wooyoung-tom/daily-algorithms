package daily_240813

/**
 * 백준 1966번. 프린터 큐
 */
fun solution1966() {
    // 테스트 케이스의 개수
    val t = readln().toInt()

    repeat(t) {
        solution()
    }
}

private fun solution() {
    // 문서의 개수 N, 궁금한 문서의 위치 M
    val (_, m) = readln().split(" ").map { it.toInt() }
    // 문서의 중요도
    val importance = readln().split(" ").map { it.toInt() }

    // 문서의 중요도와 인덱스를 Pair로 묶어서 저장
    val queue = importance.mapIndexed { index, i -> index to i }.toMutableList()

    var count = 0
    while (queue.isNotEmpty()) {
        val current = queue.removeAt(0)
        // 중요도가 가장 높은 문서가 아닌 경우
        if (queue.any { it.second > current.second }) {
            queue.add(current)
        } else {
            count++
            // 궁금한 문서가 출력되었을 때
            if (current.first == m) return println(count)
        }
    }
}
