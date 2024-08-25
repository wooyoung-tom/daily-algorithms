package daily_240825

/**
 * 백준 1620번 - 나는야 포켓몬 마스터 이다솜
 */
fun solution1620() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // 도감에 수록된 포켓몬 수 N, 맞춰야 할 포켓몬 수 M
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val dictionaryByNumber = mutableMapOf<Int, String>()
    val dictionaryByMonster = mutableMapOf<String, Int>()

    // 도감 입력
    (1..N).forEach { index ->
        val monster = br.readLine()
        dictionaryByNumber[index] = monster
        dictionaryByMonster[monster] = index
    }

    repeat(M) {
        val question = br.readLine()
        try {
            bw.write("${dictionaryByNumber[question.toInt()]}\n")
        } catch (e: Exception) {
            bw.write("${dictionaryByMonster[question]}\n")
        }
    }

    bw.flush()
    bw.close()
}
