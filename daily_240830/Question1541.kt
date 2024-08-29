package daily_240830

/**
 * 백준 1541번 - 잃어버린 괄호
 */
fun solution1541() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // 식 입력
    val input = br.readLine()

    // - 기준으로 나누기
    val splitByMinus = input.split("-")

    // 첫 번째 부분을 양수로 처리
    var result = splitByMinus[0].split("+").sumOf { it.toInt() }

    // 나머지 부분은 모두 빼줌
    for (i in 1..<splitByMinus.size) {
        result -= splitByMinus[i].split("+").sumOf { it.toInt() }
    }

    // 결과 출력
    bw.write("$result")

    bw.flush()
    bw.close()
}
