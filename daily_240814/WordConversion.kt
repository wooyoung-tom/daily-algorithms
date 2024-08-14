package daily_240814

/**
 * 프로그래머스 - 단어 변환
 */
class WordConversion {
    private var result: Int = Int.MAX_VALUE

    private val checked = mutableMapOf<String, Boolean>()

    fun solution(begin: String, target: String, words: Array<String>): Int {
        // words 배열 안에 target 이 없는 경우
        if (words.contains(target).not()) return 0

        // 확인 여부 배열 초기화
        words.forEach { checked.putIfAbsent(it, false) }

        dfs(words, begin, target)

        return result
    }

    private fun dfs(words: Array<String>, word: String, target: String) {
        if (word == target) return let {
            result = result.coerceAtMost(checked.count { it.value })
        }

        words.filter { word countDiff it == 1 }
            .filter { checked[it] == false }
            .forEach { nextWord ->
                checked[nextWord] = true
                dfs(words, nextWord, target)
                checked[nextWord] = false
            }
    }

    private infix fun String.countDiff(other: String): Int {
        return this.zip(other).count { (char1, char2) -> char1 != char2 }
    }
}