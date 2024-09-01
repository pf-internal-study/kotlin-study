package internal.study.kotlin.min

class RoundMin {
    private val _records: MutableMap<PlayerMin, List<Int>> = mutableMapOf()
    private var winner: PlayerMin? = null

    val records: Map<PlayerMin, List<Int>>
        get() = _records.toMap()

    /* 라운드 시작 */
    fun run(players: List<PlayerMin>) {
        players.forEach { player ->
            val diceResults = player.rollDice()
            _records[player] = diceResults
        }

        val maxScore = _records.maxOfOrNull { (_, diceResults) -> diceResults.sum() }
            ?: throw IllegalStateException("점수를 계산할 수 없습니다.")

        val candidates = _records.filterValues { it.sum() == maxScore }.keys

        if (candidates.size == 1) {
            winner = candidates.first()
            return
        }

        run(candidates.toList())
    }

    /* 라운드 승자 리턴 */
    fun getRoundWinner(): PlayerMin {
        return winner ?: throw IllegalStateException("승자가 정해지지 않았습니다.")
    }
}
