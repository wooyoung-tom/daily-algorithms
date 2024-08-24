package daily_240823

/**
 * 백준 1074번 - Z
 * 처음에는 계속 size 를 줄여가며 재귀적으로 모두 탐색을 하였음 - 시간초과
 * (r, c)가 어느 사분면에 있는지 파악만 하면 쉽게 찾을 수 있음
 */
fun solution1074() {
    val (N, r, c) = readln().split(" ").map { it.toInt() }

    var result = 0
    var size = 1 shl N  // 2^N

    var y = r
    var x = c

    while (size > 1) {
        size /= 2

        if (y < size && x < size) {
            // 1사분면: 아무 일도 하지 않음, 그대로 진행
        } else if (size in (y + 1)..x) {
            // 2사분면: 이전 사분면(1사분면) 크기만큼 더해줌
            result += size * size
            x -= size
        } else if (size in (x + 1)..y) {
            // 3사분면: 1사분면과 2사분면 크기만큼 더해줌
            result += 2 * size * size
            y -= size
        } else {
            // 4사분면: 1사분면, 2사분면, 3사분면 크기만큼 더해줌
            result += 3 * size * size
            y -= size
            x -= size
        }
    }

    result += y * 2 + x
    println(result)
}
