package internal.study.kotlin.shy

import kotlin.random.Random


class Player(var name : String, var nickName: String?) {
    companion object {
        const val DEFAULT_NICK_NAME = "anonymous@"

        fun randomNumber(): Int {
            return Random.nextInt(100) + 1
        }
    }

    init {
        if (nickName.isNullOrEmpty()) {
            nickName = DEFAULT_NICK_NAME + randomNumber()
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
}
