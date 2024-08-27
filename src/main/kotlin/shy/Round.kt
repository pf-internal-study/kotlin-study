package internal.study.kotlin.shy

class Round(private var winner: Player?) {
    private lateinit var record: MutableMap<Player, MutableList<Int>>

    fun join(player: Player) {
        record.put(player, mutableListOf())
    }

    fun addEyes(player: Player, score: Int) {
        val eyes: MutableList<Int>? = record.get(player)
        eyes!!.add(score)
        record.put(player, eyes)
    }

    fun win() {
        TODO("다음 기회에")
    }
}
