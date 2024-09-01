package daily_240901

import java.util.*

/**
 * 백준 11279번 - 최대 힙
 */
fun solution11279() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    // 연산의 개수 N
    val N = br.readLine().toInt()

    // Comparator 추가하여 최대 힙으로 변경
    val priorityQueue: PriorityQueue<Int> = PriorityQueue(N) { a: Int, b: Int -> b - a }

    fun operation() {
        val x = br.readLine().toInt()

        // 1. x가 0이라면 현재 배열에서 가장 큰 수를 출력하고 지운다.
        if (x == 0) {
            if (priorityQueue.isEmpty()) {
                bw.write("0\n")
            } else {
                bw.write("${priorityQueue.poll()}\n")
            }
        }
        // 2. x가 자연수라면 배열에 x를 추가한다.
        else {
            priorityQueue.add(x)
        }
    }

    repeat(N) {
        operation()
    }

    bw.flush()
    bw.close()
}