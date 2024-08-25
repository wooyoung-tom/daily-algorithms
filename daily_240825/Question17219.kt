package daily_240825

/**
 * 백준 17219번 - 비밀번호 찾기
 */
fun solution17219() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // 저장된 사이트 주소 수 N, 비밀번호를 찾으려는 사이트 수 M
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val dictionary = mutableMapOf<String, String>()

    repeat(N) {
        val (site, password) = br.readLine().split(" ")
        dictionary[site] = password
    }

    repeat(M) {
        val site = br.readLine()
        bw.write("${dictionary[site]}\n")
    }

    bw.flush()
    bw.close()
}