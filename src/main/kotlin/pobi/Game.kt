package internal.study.kotlin.pobi

class Game {
    private val rounds: List<Round> = (1..10).map { Round(it) }
    private var _players: MutableList<Player> = mutableListOf()
    private var finalWinner: Player? = null

    val players: List<Player>
        get() = _players.toList()

    fun joinPlayer(invitePlayer: Player) {
        check(!_players.contains(invitePlayer)) { "동일한 플레이어는 참가할수 없습니다." }

        _players.add(invitePlayer)
        /* 게임 창여시 다이스 지급 */
        invitePlayer.setDices()
    }

    fun setFinalWinner() {
        TODO("내일의 내가 만들기")
    }
}
