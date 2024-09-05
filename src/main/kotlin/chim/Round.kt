package internal.study.kotlin.chim

class Round(
    val id: Int
) {
    private val _records: MutableMap<Player, List<Int>> = mutableMapOf()
    private var _winner: Player? = null
    private var attempts: Int = 0

    val records: Map<Player, List<Int>>
        get() = _records.toMap()

    val winner: Player?
        get() = _winner

    fun run(players: List<Player>): Player {
        return pickWinner(players).also {
            _winner = it
        }
    }

    private fun pickWinner(players: List<Player>): Player {
        if (players.size == 1) {
            return players.first()
        }

        attempts++
        players.forEach {
            _records[it] = it.rollDice()
        }
        val winnerPlayers = records.filter { players.contains(it.key) }
            .winnerPlayers()
        printRound(winnerPlayers)

        return pickWinner(winnerPlayers)
    }

    private fun printRound(winners: List<Player>) {
        println("${id}라운드 ${attempts}차 시도 진행 결과")
        println("---------------")
        records.forEach {
            println("${it.key} 결과: ${it.value}  총점: ${it.value.sum()}")
        }
        println("---------------")
        println("승자: ${winners}")
        println("---------------")
    }
}
