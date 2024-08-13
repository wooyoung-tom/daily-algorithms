package daily_240813

/**
 * 백준 30802번. 웰컴 키트
 */
fun solution30802() {
    // 참가자 수 N
    val N = readln().toInt()
    // 티셔츠 사이즈 별 신청자 수
    val participants = readln().split(" ").map { it.toInt() }
    // 티셔츠와 펜의 묶음 수 T, P
    val (T, P) = readln().split(" ").map { it.toInt() }

    // 티셔츠는 S, M, L, XL, XXL, XXXL 의 6가지 사이즈가 있습니다. 티셔츠는 같은 사이즈의 T장 묶음으로만 주문할 수 있습니다.
    // 티셔츠는 남아도 되지만 부족해서는 안 되고 신청한 사이즈대로 나눠주어야 합니다.
    var tBundle = 0
    participants.forEach {
        tBundle += if (it % T == 0) it / T else it / T + 1
    }

    // 펜은 한 종류로, P 자루씩 묶음으로 주문하거나 한 자루씩 주문할 수 있습니다.
    // 펜은 남거나 부족해서는 안 되고 정확히 참가자 수만큼 준비되어야 합니다.
    val pBundle = N / P
    val pRemainder = N % P

    println(tBundle)
    println("$pBundle $pRemainder")
}
