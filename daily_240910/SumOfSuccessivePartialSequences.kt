package daily_240910

/**
 * 프로그래머스 - 연속된 부분 수열의 합
 * 기존에는 slice 하고 sum 구하는 방식으로 풀어서 시간초과 남
 * 투 포인터로 풀어야 함
 */
class SumOfSuccessivePartialSequences {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var start = 0
        var end = 0

        var currentSum = 0

        var minLength = Int.MAX_VALUE

        var result = intArrayOf(-1, -1)

        while (end < sequence.size) {
            currentSum += sequence[end]

            while (currentSum >= k) {
                if (currentSum == k) {
                    if (end - start < minLength) {
                        minLength = end - start
                        result = intArrayOf(start, end)
                    }
                }
                currentSum -= sequence[start++]
            }

            end++
        }

        return result
    }
}