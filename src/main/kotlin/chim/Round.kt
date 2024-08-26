package internal.study.kotlin.chim

class Round(
    val id: Int
) {
    val records: MutableMap<Player, List<Int>> = mutableMapOf()
    var winner: Player? = null
}
