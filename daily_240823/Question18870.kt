package daily_240823

/**
 * 백준 18870번 - 좌표 압축
 */
fun solution18870() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // 수직선 위 N개의 좌표
    val N = br.readLine().toInt()

    // N개의 좌표
    val coordinates = br.readLine()
        .split(" ")
        .map { it.toBigInteger() }

    // 좌표 리스트 복사 후 정렬 (좌표 하나씩만 있게 함)
    val sortedCoordinates = coordinates.distinct().sorted()

    // 좌표 압축을 위한 맵핑 생성
    // 정렬 되어 있으니까, index 가 나보다 작은 수의 개수임
    val mapCoordinates = sortedCoordinates
        .withIndex()
        .associate { it.value to it.index }

    coordinates.forEach {
        bw.write("${mapCoordinates[it]} ")
    }

    bw.flush()
    bw.close()
}
