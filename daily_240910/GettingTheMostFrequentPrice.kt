package daily_240910

/**
 * 프로그래머스 - 최빈값 구하기
 */
class GettingTheMostFrequentPrice {
    fun solution(array: IntArray): Int {
        // 각 원소의 등장 횟수를 계산
        val countMap = array.toList().groupingBy { it }.eachCount()

        // 등장 횟수를 key로, 그 등장 횟수를 가진 원소들의 리스트를 value로 하는 Map 생성
        val resultMap = mutableMapOf<Int, MutableList<Int>>()

        for ((num, count) in countMap) {
            resultMap.computeIfAbsent(count) { mutableListOf() }.add(num)
        }

        // 등장 횟수가 가장 많은 원소 반환
        return resultMap.maxByOrNull { it.key }
            ?.value
            ?.takeIf { it.size == 1 }
            ?.first()
            ?: -1
    }
}