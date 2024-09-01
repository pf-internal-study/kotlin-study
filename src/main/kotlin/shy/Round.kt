package internal.study.kotlin.shy

class Round {
    private val _records: MutableMap<Player, List<Int>> = mutableMapOf()
    var winner: Player? = null

    val records: Map<Player, List<Int>>
        get() = _records.toMap()

    fun run(players: List<Player>): Player{
        players.forEach { player ->
            player.rollDice()
            _records[player] = player.getEyes()
        }

        printRound()

        // 재수행 검증 처리
        val sameScorePlayers = checkSameScore()
        if (sameScorePlayers.size > 1) {
            run(sameScorePlayers)
        }
        else {
            win(players)
        }

        println("라운드 승자는 ${winner!!.name} 입니다.")
        return winner!!;
    }

    private fun win(players: List<Player>) {
        winner = _records
            .filterKeys { it in players }
            .maxByOrNull { (_, diceResults) -> diceResults.sum() }
            ?.key
    }

    private fun printRound() {
        _records.forEach { (player, diceResults) ->
            println("플레이어[${player.name}]: ${diceResults.sum()}")
        }
    }

    private fun checkSameScore(): List<Player> {
        val sumMap = _records.mapValues { (_, record) -> record.sum() }
        val maxSum = sumMap.values.maxOrNull() ?: 0

        return sumMap.filter { it.value == maxSum }.keys.toList()
    }
}
