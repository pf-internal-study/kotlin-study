package internal.study.kotlin.chim

class Round(
    val id: Int
) {
    private val _records: MutableMap<Player, List<Int>> = mutableMapOf()
    private var _winner: Player? = null

    val records: Map<Player, List<Int>>
        get() = _records.toMap()

    val winner: Player?
        get() = _winner

    fun run(players: List<Player>): Player {
        players.forEach {
            _records[it] = it.rollDice()
        }

        val winnerPlayers = records.filter { players.contains(it.key) }
            .winnerPlayers()
        _winner = when {
            winnerPlayers.size == 1 -> winnerPlayers.first()
            else -> run(winnerPlayers)
        }
        println("${id}라운드 진행 결과")
        println("기록: ${records}")
        println("승자: ${winner}")
        return winner!!
    }
}
