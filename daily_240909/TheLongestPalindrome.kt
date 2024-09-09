package daily_240909

/**
 * 프로그래머스 - 가장 긴 팰린드롬
 */
class TheLongestPalindrome {
    fun solution(s: String): Int {
        var answer = 0

        fun expandAroundCenter(left: Int, right: Int): Int {
            var l = left
            var r = right
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l--
                r++
            }
            return r - l - 1
        }

        for (i in s.indices) {
            // 홀수 길이 팰린드롬
            val len1 = expandAroundCenter(i, i)
            // 짝수 길이 팰린드롬
            val len2 = expandAroundCenter(i, i + 1)
            answer = maxOf(answer, len1, len2)
        }

        return answer
    }
}
