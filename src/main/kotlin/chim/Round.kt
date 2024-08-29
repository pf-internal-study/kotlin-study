package internal.study.kotlin.chim

class Round(
    val id: Int
) {
    private val _records: MutableMap<Player, List<Int>> = mutableMapOf()
    var winner: Player? = null

    val records: Map<Player, List<Int>>
        get() = _records.toMap()
}
