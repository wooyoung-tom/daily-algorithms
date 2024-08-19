package daily_240819

import java.util.PriorityQueue

/**
 * 백준 1927번 - 최소 힙
 */
fun solution1927() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // 연산 개수 N
    val N = br.readLine().toInt()

    val minimumHeap = PriorityQueue<Int>()

    repeat(N) {
        val num = br.readLine().toInt()
        if (num == 0) {
            if (minimumHeap.isEmpty()) {
                bw.write("0\n")
            } else {
                bw.write("${minimumHeap.poll()}\n")
            }
        } else {
            minimumHeap.add(num)
        }
    }

    bw.flush()
    bw.close()
}
