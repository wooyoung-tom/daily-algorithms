package daily_240904

/**
 * 백준 5525번 - IOIOI
 */
fun solution5525() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    // N
    val N = br.readLine().toInt()

    // S의 길이 M
    val M = br.readLine().toInt()

    // S
    val S = br.readLine()

    var result = 0
    var count = 0
    var i = 1

    while (i < M - 1) {
        if (S[i - 1] == 'I' && S[i] == 'O' && S[i + 1] == 'I') {
            count++
            if (count == N) {
                count--
                result++
            }
            i += 2
        } else {
            count = 0
            i++
        }
    }

    bw.write("$result")

    bw.flush()
    bw.close()
}