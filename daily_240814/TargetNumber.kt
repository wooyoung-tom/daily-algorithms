package daily_240814

/**
 * 프로그래머스 - 타겟 넘버
 */
class TargetNumber {
    fun solution(numbers: IntArray, target: Int): Int {
        return dfs(numbers, target, 0, 0)
    }

    private fun dfs(numbers: IntArray, target: Int, index: Int, sum: Int): Int {
        if (index == numbers.size) return if (sum == target) 1 else 0

        return dfs(numbers, target, index + 1, sum + numbers[index]) +
                dfs(numbers, target, index + 1, sum - numbers[index])
    }
}