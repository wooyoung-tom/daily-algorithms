/**
 * 백준 4375번. 1
 */
fun solution4375() {
    while (true) {
        val numberString = readlnOrNull() ?: break

        val number = numberString.toInt()
        var count = 1
        var oneNumber = 1.0

        if (number % 2 == 0 || number % 5 == 0) {
            continue
        }

        while (true) {
            if (oneNumber % number == 0.0) {
                break
            } else {
                oneNumber = (oneNumber * 10 + 1) % number
                count++
            }
        }

        println("$count")
    }
}