package internal.study.kotlin.chim

class RecordSheet {
    private val _records: MutableMap<Player, List<Int>> = mutableMapOf()

    val records: Map<Player, List<Int>>
        get() = _records

    val winners: List<Player>
        get() {
            val maxPoint = records.maxOf { it.value.sum() }
            return records.filterValues { it.sum() == maxPoint }
                .map { it.key }
        }

    fun put(player: Player, score: List<Int>) {
        _records[player] = score
    }

    fun print() {
        records.forEach { (player, score) ->
            println("${player} 결과: ${score}  총점: ${score.sum()}")
        }
        println("---------------")
        println("승자: ${winners}")
    }

}
