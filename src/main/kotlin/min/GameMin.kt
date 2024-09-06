package internal.study.kotlin.min

class GameMin {
    private val rounds: List<RoundMin> = List(TOTAL_ROUNDS) { RoundMin() }
    private val _players: MutableList<PlayerMin> = mutableListOf()
    private var _winner: PlayerMin? = null

    val players: List<PlayerMin>
        get() = _players.toList()

    val winner: PlayerMin?
        get() = _winner

    /* 게임 참가 */
    fun join(player: PlayerMin) {
        if (_players.contains(player)) {
            throw IllegalArgumentException("${player.name}는 이미 참여하였습니다.")
        }
        player.setDice(List(DICE_GIVEN_COUNT) { DiceMin() })
        _players.add(player)
    }

    /* 게임 시작 */
    fun run() {
        check(_players.isNotEmpty()) {
            "이 시점에 참가자가 없을 수 없는데 없습니다. 준한테 문의해주세욬ㅋ"
        }

        rounds.forEachIndexed { index, round ->
            round.run(_players)
            printRoundResults(index + 1, round)
        }
        determineFinalWinner()
        printFinalResults()

    }

    /* 최종 우승자 결정 */
    private fun determineFinalWinner() {
        _winner = players.maxBy { player ->
            rounds.count { round -> round.winner == player }
        }
    }

    /* 라운드 결과 출력 */
    private fun printRoundResults(roundIndex: Int, round: RoundMin) {
        println("Round $roundIndex 결과:")
        println("=====================================")
        round.records.forEach { record -> println("  ${record}") }
        println("Round $roundIndex 승자는! ${round.winner!!.name}")
        println("=====================================")
        println()
    }

    /* 최종 우승자 출력 */
    private fun printFinalResults() {
        check(winner != null) { "최종 우승자가 정해지지 않았습니다. 게임을 돌려주세욬ㅋ" }
        println("==============게임 종료==============")
        println("진행 라운드: ${rounds.size}")
        println("최종 우승자: ${winner!!.name}")
        println("총 승리 라운드: ${rounds.count { round -> round.winner == winner }}")
        println("=====================================")
        println("GG RE?")
    }

    companion object {
        private const val TOTAL_ROUNDS = 10
        private const val DICE_GIVEN_COUNT = 5
    }
}
