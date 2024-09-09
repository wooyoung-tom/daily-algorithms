package daily_240910

/**
 * 프로그래머스 - 정수를 나선형으로 배치하기
 * 왜 BFS 로 하면 시간초과가 발생하는가? - 메모리?
 *
 */
class PlacingIntegersInASpiralShape {
    fun solution(n: Int): Array<IntArray> {
        val spiral = Array(n) { IntArray(n) }
        var (x, y) = 0 to 0
        var direction = 0 // 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위
        val dx = intArrayOf(0, 1, 0, -1) // x 방향 배열
        val dy = intArrayOf(1, 0, -1, 0) // y 방향 배열
        var num = 1
        while (num <= n * n) {
            spiral[x][y] = num
            num++

            // 다음 위치 계산
            val nx = x + dx[direction]
            val ny = y + dy[direction]

            // 범위를 벗어나거나 이미 채워진 위치인 경우 방향 전환
            if (nx !in 0 until n || ny !in 0 until n || spiral[nx][ny] != 0) {
                direction = (direction + 1) % 4
            }

            // 다음 위치 갱신
            x += dx[direction]
            y += dy[direction]
        }

        return spiral
    }
}