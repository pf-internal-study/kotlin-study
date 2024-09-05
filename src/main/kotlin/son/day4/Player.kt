package internal.study.kotlin.son.day4

data class Player(val name: String, val dice: List<DiceEyes> = rollDice()) {
    val score: Int get() = dice.sumOf { it.eyes }

    fun rollNewDice(): Player = this.copy(dice = rollDice())

    companion object {
        fun rollDice(): List<DiceEyes> = List(5) { Dice.roll() }

        fun withFixedDice(name: String, eyes: List<Int>): Player {
            return Player(name, eyes.map { DiceEyes.of(it) })
        }
    }
}