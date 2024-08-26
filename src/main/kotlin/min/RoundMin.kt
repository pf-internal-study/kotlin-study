package internal.study.kotlin.min

class RoundMin {
    private val records: MutableMap<PlayerMin, List<Int>> = mutableMapOf()
    private var winner: PlayerMin? = null

    /* 라운드 시작 */
    fun playRound(players: List<PlayerMin>) {
        players.forEach { player ->
            val diceResults = rollDice()
            records[player] = diceResults
        }
        determineWinner()
    }

    /* 주사위 굴리기 */
    private fun rollDice(): List<Int> {
        val dice = DiceMin()
        return List(5) { dice.roll() }
    }

    /* 해당 라운드 승자 결정 */
    private fun determineWinner() {
        TODO("승자 결정 구현")
    }

    /* 해당 라운드 승자 리턴 */
    fun getRoundWinner(): PlayerMin {
        TODO("라운드 승자 리턴")
    }
}
