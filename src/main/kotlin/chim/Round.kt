package internal.study.kotlin.chim

class Round(
    val id: Int
) {
    private val _recordSheets: MutableList<RecordSheet> = mutableListOf()
    private var _winner: Player? = null

    val recordSheets: List<RecordSheet>
        get() = _recordSheets

    val winner: Player?
        get() = _winner

    fun run(players: List<Player>): Player {
        return pickWinner(players).also {
            _winner = it
        }
    }

    private tailrec fun pickWinner(players: List<Player>): Player {
        if (players.size == 1) {
            return players.first()
        }

        val recordSheet = RecordSheet().apply {
            players.forEach { put(it, it.rollDice()) }
            _recordSheets += this
        }
        return pickWinner(recordSheet.winners)
    }

    fun print() {
        recordSheets.forEachIndexed { index, sheet ->
            println("${index + 1}차 시도 진행 결과")
            println("---------------")
            sheet.print()
            println("---------------")
        }
    }
}
