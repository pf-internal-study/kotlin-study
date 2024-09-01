package internal.study.kotlin.son.day4

data class Player(val name: String, val dice: List<DiceEyes> = rollDice()) {
    val score: Int get() = dice.sumOf { it.eyes }

    companion object {
        fun rollDice(): List<DiceEyes> = List(5) { Dice.roll() }
    }
}