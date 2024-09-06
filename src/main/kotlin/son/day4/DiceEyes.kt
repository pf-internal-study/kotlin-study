package internal.study.kotlin.son.day4

@JvmInline
value class DiceEyes private constructor(val eyes: Int) {
    companion object {
        fun of(eyes: Int): DiceEyes {
            require(eyes in 1..6) { "주사위의 눈금은 1~6 사이여야 합니다." }
            return DiceEyes(eyes)
        }
    }
}