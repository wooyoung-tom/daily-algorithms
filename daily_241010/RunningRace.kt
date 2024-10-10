package daily_241010

/**
 * 프로그래머스 - 달리기 경주
 */
class RunningRace {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val rank = mutableMapOf<String, Int>()
        // 현재 순위
        players.forEachIndexed { index, s -> rank[s] = index }

        callings.forEachIndexed { index, callingPlayer ->
            val currentRank = rank[callingPlayer] ?: 0
            val previousRankPlayer = players[currentRank - 1]

            // 현재 순위를 변경
            players[currentRank - 1] = callingPlayer
            players[currentRank] = previousRankPlayer

            // 순위 변경
            rank[callingPlayer] = currentRank - 1
            rank[previousRankPlayer] = currentRank
        }

        return players
    }
}