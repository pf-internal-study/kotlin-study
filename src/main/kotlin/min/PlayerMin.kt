package internal.study.kotlin.min

data class PlayerMin(
    val name: String,
    val nickname: String = generateRandomNickname(),
    private var _dice: List<DiceMin>? = null
) {
    companion object {
        fun generateRandomNickname(): String {
            val randomValue = (1..100).random()
            return "anonymous@$randomValue"
        }
    }

    fun setDice(dice: List<DiceMin>) {
        check(_dice == null) { "주사위는 할당받은 이후 변경할 수 없습니다." }
        _dice = dice
    }

    fun rollDice(): List<Int> {
        return _dice?.map { it.roll() } ?: throw IllegalStateException("할당받은 주사위가 없습니다.")
    }

    fun getDiceResults(): List<Int> {
        return this.rollDice()
    }
}
