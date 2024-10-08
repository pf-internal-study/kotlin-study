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
        print(_records)
        val currentRoundRecords = _records.filterKeys { it in players }
        val maxScore = currentRoundRecords.maxOfOrNull { (_, diceResults) -> diceResults.sum() }
            ?: throw IllegalStateException("점수를 계산할 수 없습니다.")
        val candidates = currentRoundRecords.filterValues { it.sum() == maxScore }.keys

        if (candidates.size == 1) {
            winner = candidates.first()
            println("우승자!: ${winner?.name} 점수: ${currentRoundRecords[winner]?.sum()}")
            return
        }
        run(candidates.toList())
    }

    /* 라운드 승자 리턴 */
    fun getRoundWinner(): PlayerMin {
        return winner ?: throw IllegalStateException("승자가 정해지지 않았습니다.")
    }

    fun print(records : MutableMap<PlayerMin, List<Int>>) {
        println("라운드 결과:")
        records.forEach { (player, results) ->
            println("${player.name}: ${results.sum()} (${results.joinToString(", ")})")
        }
    }
}
