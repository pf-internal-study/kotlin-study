package internal.study.kotlin.dennis

@JvmInline
value class DieNumber private constructor(
    val value: Int,
) {
    companion object {
        fun from(value: Int): DieNumber {
            require(value in 1..6) { "Dice number must be between 1 and 6" }
            return DieNumber(value)
        }
    }
}
