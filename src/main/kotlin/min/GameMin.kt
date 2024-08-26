package internal.study.kotlin.min

class GameMin {
    private val rounds: MutableList<Round> = MutableList(10) { Round() }
    private val players: MutableList<PlayerMin> = mutableListOf()
    private var winner: PlayerMin? = null

    /* 게임 참가 */
    fun join(player: PlayerMin) {
        if (players.contains(player)) {
            throw IllegalArgumentException("${player.name}는 이미 참여하였습니다.")
        }
        players.add(player)
    }

    /* 게임 시작 */
    fun start() {
        if (players.isEmpty()) {
            throw IllegalStateException("참가자가 없습니다.")
        }

        rounds.forEach { round -> round.playRound(players) }
        determineFinalWinner()
    }

    /* 최종 우승자 결정 */
    private fun determineFinalWinner() {
        TODO("라운드 최종 승 결정")
    }

    /* 최종 우승자 반환 */
    fun getFinalWinner(): PlayerMin {
        TODO("라운드 승자 리턴")
    }
}
