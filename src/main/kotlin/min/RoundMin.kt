package internal.study.kotlin.min

class RoundMin {
    private val _records: MutableList<RecordMin> = mutableListOf()
    private var _winner: PlayerMin? = null
    private var attempts: Int = 0

    val records: List<RecordMin>
        get() = _records.toList()

    val winner: PlayerMin?
        get() = _winner

    /* 라운드 시작 */
    fun run(players: List<PlayerMin>) {
        require(players.isNotEmpty()) {
            "이 시점에 플레이어가 없을 수 없는데 없습니다. 에린한테 문의해주세욬ㅋ"
        }

        attempts++
        val roundRecords = players.map { player ->
            RecordMin(player, player.rollDice(), attempts)
        }
        _records.addAll(roundRecords)

        val maxScore = roundRecords.maxOf { it.score }
        val candidates = roundRecords.filter { it.score == maxScore }.map { it.player }

        when (candidates.size) {
            1 -> _winner = candidates.first()
            else -> run(candidates)
        }
    }
}
