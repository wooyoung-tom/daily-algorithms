package daily_240910

/**
 * 프로그래머스 - OX 퀴즈
 */
class OXQuiz {
    fun solution(quiz: Array<String>): Array<String> {
        val splitter: List<List<String>> = quiz.map { it.split(" ") }
        val result = mutableListOf<String>()

        splitter.forEach {
            val numbers = mutableListOf<Int>()
            val operators = mutableListOf<String>()

            it.forEach { element ->
                element.toIntOrNull()
                    ?.let { number -> numbers.add(number) }
                    ?: operators.add(element)
            }

            val rightHand = numbers[0]
            val leftHand = numbers[1]
            val operator = operators[0]

            val correct = if (operator == "+") {
                rightHand + leftHand == numbers[2]
            } else {
                rightHand - leftHand == numbers[2]
            }

            result.add(if (correct) "O" else "X")
        }

        return result.toTypedArray()
    }
}