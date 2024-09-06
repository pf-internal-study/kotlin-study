package internal.study.kotlin.chim

class Player(
    val name: String,
    nickname: String?
) {
    val nickname by lazy {
//        when (nickname) {
//            null -> "anonymous@${(1..100).random()}"
//            else -> nickname
//        }
        nickname ?: "anonymous@${(1..100).random()}"
    }

    private lateinit var dice: List<Dice>

    fun addDice() {
        dice = List(5) { Dice() }
    }

    fun hasDice(): Boolean {
        return try {
            dice.isNotEmpty()
        } catch (e: UninitializedPropertyAccessException) {
            false
        }
    }

    fun rollDice(): List<Int> {
        return dice.map { it.roll() }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Player

        if (name != other.name) return false
        if (nickname != other.nickname) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + nickname.hashCode()
        return result
    }

    override fun toString(): String {
        return nickname
    }
}
