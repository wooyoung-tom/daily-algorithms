package daily_240814

/**
 * 백준 28702번. FizzBuzz
 */
fun solution28702() {
    // 입력값 받기
    val inputs = Array(3) { "" }
    repeat(3) { inputs[it] = readln() }

    // 이 입력값은 다음과 같이 매칭됨
    // 1. i가 3의 배수이면서 5의 배수이면 "FizzBuzz"
    // 2. i가 3의 배수이지만 5의 배수가 아니면 "Fizz"
    // 3. i가 3의 배수가 아니지만 5의 배수이면 "Buzz"
    // 4. i가 3의 배수도 아니고 5의 배수도 아닌 경우 i를 그대로 출력
    // 세 개의 입력값이 모두 문자열일 경우는 존재하지 않음
    val integers: List<Int?> = inputs.map { it.toIntOrNull() }
    val target: Int = integers.filterNotNull().first()
    val index = integers.indexOf(target)

    // i 찾기
    val i = target + (3 - index)

    if (i % 3 == 0 && i % 5 == 0) println("FizzBuzz")
    else if (i % 3 == 0) println("Fizz")
    else if (i % 5 == 0) println("Buzz")
    else println(i)
}