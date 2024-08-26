package internal.study.kotlin.dennis

@JvmInline
value class DiceNumber private constructor(
    val value: Int,
) {
    companion object {
        fun from(value: Int): DiceNumber {
            require(value in 1..6) { "Dice number must be between 1 and 6" }
            return DiceNumber(value)
        }
    }
}
