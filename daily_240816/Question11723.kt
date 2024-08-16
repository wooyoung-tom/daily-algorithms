package daily_240816

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 백준 11723번 - 집합
 */
fun solution11723() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var S = 0 // 비트마스크로 집합을 표현
    val M = br.readLine().toInt()

    repeat(M) {
        val input = br.readLine().split(" ")
        val operator = input[0]
        val value = if (input.size > 1) input[1].toInt() else 0

        when (operator) {
            "add" -> S = S or (1 shl (value - 1))
            "remove" -> S = S and (1 shl (value - 1)).inv()
            "check" -> bw.write(((S shr (value - 1)) and 1).toString() + "\n")
            "toggle" -> S = S xor (1 shl (value - 1))
            "all" -> S = (1 shl 20) - 1
            "empty" -> S = 0
        }
    }

    bw.flush()
    bw.close()
}
