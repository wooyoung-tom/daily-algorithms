package daily_240817

/**
 * 백준 11399번 - ATM
 */
fun solution11399() {
    // 사람 수 N
    val N = readln().toInt()

    val arr = readln().split(" ").map { it.toInt() }.sorted()

    var sum = 0
    var result = 0
    arr.forEach {
        sum += it
        result += sum
    }

    println(result)
}