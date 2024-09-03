package daily_240903

/**
 * 백준 30804번 - 과일 탕후루
 */
fun solution30804() {
    val bw = System.out.bufferedWriter()
    val br = System.`in`.bufferedReader()

    // 과일 개수 N
    val N = br.readLine().toInt()

    // 탕후루에 꽂힌 과일
    val fruits = br.readLine()
        .split(" ")
        .map { it.toInt() }

    var maxLen = 0
    var start = 0
    val countMap = mutableMapOf<Int, Int>()

    for (end in 0..<N) {
        val fruit = fruits[end]
        countMap[fruit] = countMap.getOrDefault(fruit, 0) + 1

        while (countMap.size > 2) {
            val startFruit = fruits[start]
            countMap[startFruit] = countMap[startFruit]!! - 1

            if (countMap[startFruit] == 0) {
                countMap.remove(startFruit)
            }
            start++
        }

        maxLen = maxOf(maxLen, end - start + 1)
    }

    bw.write("$maxLen\n")
    bw.flush()
    bw.close()
}
