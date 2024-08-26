package internal.study.kotlin.dennis

class Record(
    private val player: Player,
) {
    private val _dice = mutableListOf<Die>()

    val dice: List<Die>
        get() = _dice

    val playerName: String
        get() = player.name

    fun addDie(die: Die) {
        require(_dice.size < 5) { "Cannot add more than 5 dice." }
        _dice.add(die)
    }
}
