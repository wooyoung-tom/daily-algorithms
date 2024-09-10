package daily_240910

/**
 * 프로그래머스 - 한 번만 등장한 문자
 */
class CharacterThatHasAppearedOnlyOnce {
    fun solution(s: String): String {
        val once = s.groupBy { it }.filter { it.value.size == 1 }
        return if (once.isNotEmpty()) {
            once.keys.sorted().joinToString("")
        } else {
            ""
        }
    }
}