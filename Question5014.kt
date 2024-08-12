import java.util.*

/**
 * 5014. 스타트링크
 */
fun solution5014() {
    val (F, S, G, U, D) = readln().split(" ").map { it.toInt() }

    // 해당 층에 방문했는지 확인 - (1 ~ F)
    val visited = BooleanArray(F + 1) { false }
    val queue: Queue<Int> = LinkedList()

    // S 층부터 시작
    queue.add(S)
    visited[S] = true

    var countOfButtonClick = 0

    while (queue.isNotEmpty()) {
        // 현재 큐에 들어있는 만큼만 반복
        repeat(queue.size) {
            val currentFloor = queue.poll()

            // G 층에 도착했는지 확인
            if (currentFloor == G) return println(countOfButtonClick)

            // 위쪽 버튼을 누른 경우
            val up = currentFloor + U
            if (up in 1..F && !visited[up]) {
                queue.add(up)
                visited[up] = true
            }

            // 아래쪽 버튼을 누른 경우
            val down = currentFloor - D
            if (down in 1..F && !visited[down]) {
                queue.add(down)
                visited[down] = true
            }
        }
        countOfButtonClick++
    }

    println("use the stairs")
}