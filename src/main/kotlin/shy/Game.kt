package internal.study.kotlin.shy


class Game{
    private var rounds: List<Round> = ArrayList(10)
    private var players: List<Player> = ArrayList()
    private lateinit var winner: Player

    /**
     * 게임에 참가
     */
    fun join(player: Player){
        if (players.contains(player))
            throw Exception("이미 참가한 플레이어 입니다.")

        players.add(player)
    }

    /***
     * 승리자를 확인
     */
    fun win(): Player {
        players.map {
            player -> find(player)
            winner = player
        }

        return winner
    }

    /**
     * 플레이어별 총 점수를 확인
     */
    private fun find(player: Player): List<Int> {
        TODO("다음 기회에")
    }
}
