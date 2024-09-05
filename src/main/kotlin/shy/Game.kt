package internal.study.kotlin.shy


class Game {
    private val _rounds: List<Round> = List(ROUNDS_COUNT) { Round() }
    private val _players: MutableList<Player> = mutableListOf()
    var winner: Player? = null

    val players: List<Player>
        get() = _players.toList()

    val rounds: List<Round>
        get() = _rounds.toList()


    fun join(players: List<Player>) {
        players.forEach {player -> join(player)}
    }

    /**
     * 게임에 참가
     */
    fun join(player: Player){
        if (_players.contains(player))
            throw IllegalStateException("이미 참가한 플레이어 입니다.")

        _players.add(player)
    }

    fun start() {
        rounds.forEach { round ->
            println("------------------ round start -------------------")
            round.run(_players)
            println("------------------ round end -------------------")
        }
    }

    /***
     * 승리자를 확인
     */
    fun win(): Player {
       TODO("다음 기회에")
    }

    companion object {
        private const val ROUNDS_COUNT = 10
    }
}
