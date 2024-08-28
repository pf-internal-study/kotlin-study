package internal.study.kotlin.shy

class Round {
    private val _records: MutableMap<Player, List<Int>> = mutableMapOf()
    var winner: Player? = null

    val records: Map<Player, List<Int>>
        get() = _records.toMap()

    fun join(player: Player) {
        TODO("다음 기회에")
    }

    fun win() {
        TODO("다음 기회에")
    }
}
