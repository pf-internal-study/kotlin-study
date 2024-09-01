package internal.study.kotlin.min

class GameMin {
    private val rounds: List<RoundMin> = List(TOTAL_ROUNDS) { RoundMin() }
    private val _players: MutableList<PlayerMin> = mutableListOf()
    private var winner: PlayerMin? = null

    val players: List<PlayerMin>
        get() = _players.toList()

    /* 게임 참가 */
    fun join(player: PlayerMin) {
        if (_players.contains(player)) {
            throw IllegalArgumentException("${player.name}는 이미 참여하였습니다.")
        }
        player.setDice(List(DICE_GIVEN_COUNT) { DiceMin() })
        _players.add(player)
    }

    /* 게임 시작 */
    fun run() {
        if (_players.isEmpty()) {
            throw IllegalStateException("참가자가 없습니다.")
        }

        rounds.forEach { round -> round.run(_players) }
        determineFinalWinner()
    }

    /* 최종 우승자 결정 */
    private fun determineFinalWinner() {
        winner = players.maxByOrNull { player ->
            rounds.count { round -> round.getRoundWinner() == player }
        }
    }

    /* 최종 우승자 반환 */
    fun getFinalWinner(): PlayerMin {
        return winner ?: throw IllegalStateException("게임이 아직 끝나지 않았습니다.")
    }

    companion object {
        private const val TOTAL_ROUNDS = 10
        private const val DICE_GIVEN_COUNT = 5
    }
}
