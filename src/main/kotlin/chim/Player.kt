package internal.study.kotlin.chim

import java.util.Random

class Player(
    val name: String,
    nickname: String?
) {
    val nickname by lazy {
        when (nickname) {
            null -> "anonymous@${(1..100).random()}"
            else -> nickname
        }
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
}
