package daily_240904

/**
 * 백준 1389번 - 케빈 베이컨의 6단계 법칙
 * 플로이드-와샬 알고리즘 사용
 */
fun solution1389() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    // 유저의 수 N, 친구 관계의 수 M
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    // 유저 간 친구 관계를 저장할 2차원 배열
    val friends = List(N) {
        // 최대 100단계 까지 갈 수 있으므로 최대값으로 초기화
        IntArray(N) { 100 }
    }

    // 자기 자신과의 친구 관계는 0으로 초기화
    for (i in 0..<N) {
        friends[i][i] = 0
    }

    // 친구 관계 입력
    repeat(M) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        friends[a - 1][b - 1] = 1
        friends[b - 1][a - 1] = 1
    }

    // 플로이드 와샬 알고리즘을 이용하여 모든 유저 간의 최단 거리를 구함
    for (k in 0..<N) {
        for (i in 0..<N) {
            for (j in 0..<N) {
                if (friends[i][j] > friends[i][k] + friends[k][j]) {
                    friends[i][j] = friends[i][k] + friends[k][j]
                }
            }
        }
    }

    // 케빈 베이컨의 수를 저장할 배열
    val kevin = IntArray(N)

    // 케빈 베이컨의 수를 구함
    for (i in 0..<N) {
        for (j in 0..<N) {
            kevin[i] += friends[i][j]
        }
    }

    // 케빈 베이컨의 수가 가장 작은 유저를 출력
    val min = kevin.min()
    bw.write("${kevin.indexOfFirst { it == min } + 1}")

    bw.flush()
    bw.close()
}