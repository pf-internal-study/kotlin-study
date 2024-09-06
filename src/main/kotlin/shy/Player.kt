package internal.study.kotlin.shy

import kotlin.random.Random


class Player(var name : String, var nickName: String?) {
    private val _dices = List(5) { Dice() }

    fun rollDice() {
        _dices.forEach {dice -> dice.roll() }
    }
    fun getEyes(): List<Int> {
        return _dices.map { dice -> dice.eyes!! }
    }

    init {
        if (nickName.isNullOrEmpty()) {
            nickName = randomNickName()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Player) return false

        return name == other.name && nickName == other.nickName
    }

    override fun hashCode(): Int {
        return name.hashCode()  + nickName.hashCode()
    }

    companion object {
        fun randomNickName(): String {
            return "anonymous@${Random.nextInt(100) + 1}"
        }
    }
}
