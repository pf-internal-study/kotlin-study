package internal.study.kotlin.shy

class Round {
    private val _records: MutableMap<Player, List<Int>> = mutableMapOf()
    var winner: Player? = null

    val records: Map<Player, List<Int>>
        get() = _records.toMap()

    fun run(players: List<Player>): Player {
        players.forEach { player ->
            player.rollDice()
            _records[player] = player.getEyes()
        }

        printRound()

        // 재수행 검증 처리
        val sameScorePlayers = checkSameScore(players)
        if (sameScorePlayers.size > 1) {
            run(sameScorePlayers)
        }
        else {
            win(players)
        }

        println("라운드 승자는 ${winner!!.name} 입니다.")
        return winner!!;
    }

    /**
     * 승자를 구한다.
     * 1. 요청받은 플레이어를 필터
     * 2. 플레이어의 주사위 최대 값 확인
     * 3. 승자Player 반환
     */
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

    /***
     * 1. 요청된 플레이어 기준으로 필터처리
     * 2. 최대값을 구한다.
     * 2. 동점자를 리턴한다.
     */
    private fun checkSameScore(players: List<Player>): List<Player> {
        val target = _records.filterKeys { it in players }

        val maxSum = target.map{ it.value.sum() }
            .maxOrNull() ?: return emptyList()

        return target.filterValues { it.sum() == maxSum }
            .keys
            .toList()
    }
}
