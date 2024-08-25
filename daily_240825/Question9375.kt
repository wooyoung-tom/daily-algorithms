package daily_240825

/**
 * 백준 9375번 - 패션왕 신해빈
 */
fun solution9375() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // TC
    val TC = br.readLine().toInt()
    repeat(TC) {
        val N = br.readLine().toInt()

        val dictionary = mutableMapOf<String, Int>()

        repeat(N) {
            val (_, kind) = br.readLine().split(" ")
            dictionary[kind] = dictionary.getOrDefault(kind, 0) + 1
        }

        // 기본 값은 1
        var result = 1

        for (count in dictionary.values) {
            result *= (count + 1)
        }

        bw.write("${result - 1}\n")
    }

    bw.flush()
    bw.close()
}
