package internal.study.kotlin.shy


class Game{
    private val _rounds: MutableList<Round> = mutableListOf()
    private val _players: MutableList<Player> = mutableListOf()
    var winner: Player? = null

    val rounds: List<Round>
        get() = _rounds.toList()

    val players: List<Player>
        get() = _players.toList()


    /**
     * 게임에 참가
     */
    fun join(player: Player){
        if (_players.contains(player))
            throw IllegalStateException("이미 참가한 플레이어 입니다.")

        _players.add(player)
    }

    /***
     * 승리자를 확인
     */
    fun win(): Player {
       TODO("다음 기회에")
    }
}
