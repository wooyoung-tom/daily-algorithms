package daily_240909

/**
 * 프로그래머스 - 공백으로 구분하기 1,2
 */
class SplitByBlank {
    fun solution(my_string: String): Array<String> {
        return my_string.split(" ").toTypedArray()
    }

    fun solution2(my_string: String): Array<String> {
        return my_string.split(" ")
            .filter { it.isNotBlank() }
            .toTypedArray()
    }
}