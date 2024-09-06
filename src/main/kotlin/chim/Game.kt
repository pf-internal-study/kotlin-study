package internal.study.kotlin.chim

class Game {
    private val _players: MutableList<Player> = mutableListOf()
    private val _winners: MutableSet<Player> = mutableSetOf()
    val rounds: List<Round> = (1..FINAL_ROUND).map { Round(it) }

    val players: List<Player>
        get() = _players

    val winners: Set<Player>
        get() = _winners

    fun join(player: Player) {
        check(!_players.contains(player)) { "중복 지원할 수 없습니다." }
        this._players += player
        player.addDice()
    }

    fun start() {
        check(players.isNotEmpty()) { "참여한 플레이어가 없습니다." }
        val winnersCount = rounds.map { it.run(players) }
            .groupBy { it }
            .mapValues { it.value.count() }

        val maxCount: Int = winnersCount.maxOf { it.value }
        _winners += winnersCount.filterValues { it == maxCount }.keys
    }

    fun print() {
        println("게임 시작")
        println("---------------")
        rounds.forEachIndexed { index, round ->
            println("${index + 1}라운드")
            println("---------------")
            round.print()
        }
        println("최종 우승자: ${winners}")
        println("---------------")

    }

    fun printWinners() {
        println("---------------")
        rounds.forEachIndexed { index, round ->
            println("${index + 1}라운드 승자: ${round.winner}")
        }
        println("---------------")
    }

    companion object {
        private const val FINAL_ROUND: Int = 10
    }
}
