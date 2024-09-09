package daily_240909

import kotlin.math.sqrt

/**
 * 프로그래머스 - 소수 찾기
 *
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 *
 * 순열을 이용해서 가능한 모든 숫자를 찾아냄
 */
class FindPrimeNumber {
    fun solution(numbers: String): Int {
        val numSet = mutableSetOf<Int>()

        // 모든 순열을 생성하고, 가능한 모든 숫자를 만들기 위한 재귀 함수
        fun generatePermutations(prefix: String, remaining: String) {
            // 생성된 숫자를 Set에 추가 (중복 제거)
            if (prefix.isNotEmpty()) numSet.add(prefix.toInt())
            for (i in remaining.indices) {
                generatePermutations(prefix + remaining[i], remaining.removeRange(i, i + 1))
            }
        }

        generatePermutations("", numbers)

        // 소수 판별 함수
        fun isPrime(num: Int): Boolean {
            if (num < 2) return false
            for (i in 2..sqrt(num.toDouble()).toInt()) {
                if (num % i == 0) return false
            }
            return true
        }

        return numSet.count { isPrime(it) }
    }
}