package internal.study.kotlin.chim

class Game {
    private val _players: MutableList<Player> = mutableListOf()
    val rounds: List<Round> = (1..FINAL_ROUND).map { Round(it) }
    var winner: Player? = null

    val players: List<Player>
        get() = _players.toList()

    fun join(player: Player) {
        check(!_players.contains(player)) { "중복 지원할 수 없습니다." }
        this._players += player
        player.addDice()
    }
    companion object {
        private const val FINAL_ROUND: Int = 10
    }
}
