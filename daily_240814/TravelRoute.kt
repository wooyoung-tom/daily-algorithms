package daily_240814

/**
 * 프로그래머스 - 여행경로
 */
class TravelRoute {
    private val tickets = mutableMapOf<String, MutableList<String>>()
    private val result = mutableListOf<String>()

    fun solution(tickets: Array<Array<String>>): List<String> {
        tickets.forEach { ticket ->
            val from = ticket[0]
            val to = ticket[1]
            this.tickets.computeIfAbsent(from) { mutableListOf() }.add(to)
        }.also {
            this.tickets.forEach { it.value.sort() }
        }

        dfs("ICN", tickets.size + 1)

        return result
    }

    private fun dfs(airport: String, cities: Int): Boolean {
        result.add(airport)

        // 모든 티켓을 사용한 경우 결과 반환
        if (result.size == cities) return true

        // 다음 도착지가 없는 경우
        val destinations = tickets[airport] ?: return impossible()

        for (i in destinations.indices) {
            val nextAirport = destinations.removeAt(i)
            if (dfs(nextAirport, cities)) return true
            destinations.add(i, nextAirport) // 백트래킹
        }

        return impossible()
    }

    private fun impossible(): Boolean {
        result.removeLast()
        return false
    }
}