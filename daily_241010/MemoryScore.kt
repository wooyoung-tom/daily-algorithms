package daily_241010

/**
 * 프로그래머스 - 추억 점수
 */
class MemoryScore {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf()

        val scoreMap = mutableMapOf<String, Int>()
        name.forEachIndexed { index, s -> scoreMap[s] = yearning[index] }

        photo.forEach { names ->
            var score = 0
            names.forEach { name ->
                score += scoreMap.getOrDefault(name, 0)
            }
            answer += score
        }

        return answer
    }
}