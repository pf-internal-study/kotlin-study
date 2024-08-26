package internal.study.kotlin.chim

class Game {
    val rounds: List<Round> = (1..FINAL_ROUND).map { Round(it) }
    val players: MutableList<Player> = mutableListOf()
    var winner: Player? = null


    fun join(player: Player) {
        if (players.contains(player)) {
            throw IllegalStateException("중복 지원할 수 없습니다.")
        }
        this.players += player
    }
    companion object {
        private const val FINAL_ROUND: Int = 10
    }
}
