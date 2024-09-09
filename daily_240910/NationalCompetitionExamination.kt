package daily_240910

/**
 * 프로그래머스 - 전국 뭐시기 선발고사
 */
class NationalCompetitionExamination {
    private data class Student(
        val number: Int,
        val rank: Int,
    )

    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        val students = rank.mapIndexed { index, i -> Student(index, i) }
        val validStudents = students.filter { attendance[it.number] }
        val sorted = validStudents.sortedBy { it.rank }

        val (first, second, third) = sorted.take(3).map { it.number }

        return 10_000 * first + 100 * second + third
    }
}