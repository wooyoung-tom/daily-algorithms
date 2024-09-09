package daily_240909

/**
 * 프로그래머스 - X 사이의 개수
 */
class CountOfBetweenX {
    fun solution(myString: String): IntArray {
        val lengths = mutableListOf<Int>()

        var count = 0
        for (i in myString.indices) {
            if (myString[i] == 'x') {
                lengths.add(count)
                count = 0
            } else count++
        }

        lengths.add(count)

        return lengths.toIntArray()
    }
}