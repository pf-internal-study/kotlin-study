package internal.study.kotlin.son.day3
/*
게임은 진행될 라운드(rounds)와 참여할 플레이어(players) 그리고 최종 우승자(winner)를 가진다.
게임은 10라운드로 이루어져 있다.
게임이 시작된 후 라운드 목록은 변경할 수 없다.
게임은 플레이어의 참가 지원을 받는 기능(join)이 있다.
지원한 플레이어는 참여 플레이어 (players)에 등록된다.
동일한 플레이어는 지원할 수 없다.
최종 우승자(winner)는 게임이 종료될 때, 가장 많은 라운드를 승리한 플레이어로 결정된다.
최종 우승자가 정해지기 전까지 우승자는 없다.
*/
class Game(val round: Int = 10) {
    private var _players = mutableListOf<Player>()
    private val rounds = mutableListOf(Int, records)
    private val _records = mutableMapOf<Player, Records>()
    private var _winner: Player? = null
    private var _start: Boolean = false

    val records: Map<Player, Records>
        get() = _records

    val start: Boolean
        get() = _start

    val winner: Player?
        get() = _winner

    fun join(player: Player) {
        check(!_players.contains(player)) { ALREADY_JOINED_PLAYER }
        _players.add(player)
    }

    fun set() {
        check(_players.isNotEmpty()) { NOT_FOUND_PLAYER }
        check(!_start) { ALREADY_STARTED_GAME }

        _start = true
    }

    fun playRound() {
        check(_start) { NOT_STARTED_GAME }

        val dice = Dice()

        for (i in 1..round) {
            setRound()

            val roundWinner = mutableMapOf<Player, Int>()
            playDice(dice, i, roundWinner)

            // 라운드 승자 결정
            roundWinner.maxByOrNull { it.value }?.let {
                println("round : $i winner : ${it.key.name}")
                it.key.win()
            }

            println("round : $i 완료.")
        }
    }

    private fun playDice(
        dice: Dice,
        i: Int,
        roundWinner: MutableMap<Player, Int>
    ) {
        records.forEach { (player, records) ->
            for (j in 1..5) {
                val result = dice.roll()
                records.add(result)
            }

            roundWinner[player] = records.sum()
            println("player : ${player.name} round : $i sum : ${records.sum()}")
        }
    }

    fun finish() {
        check(_start) { NOT_STARTED_GAME }

        _players.forEach { player ->
            println("${player.name} : ${player.winCount}")
        }

        val winner = _players.maxByOrNull { it.winCount }
        this._winner = winner

        println("최종 우승자는 ${winner?.name} 입니다.")
    }

    private fun setRound() {
        check(_start) { NOT_STARTED_GAME }

        _players.forEach { player ->
            _records[player] = Records(player)
        }
    }
    companion object {
        private const val NOT_FOUND_PLAYER = "참가한 플레이어가 없습니다."
        private const val ALREADY_STARTED_GAME = "이미 시작된 게임입니다."
        private const val ALREADY_JOINED_PLAYER = "이미 참가한 플레이어입니다."
        private const val NOT_STARTED_GAME = "게임이 시작되지 않았습니다."
    }
}