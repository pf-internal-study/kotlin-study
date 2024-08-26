package internal.study.kotlin.son.day1

class Player(val name: String, var nickname: String?) {

    init {
        createNickname(nickname)
    }

    private fun createNickname(nickname: String?) {
        if (nickname == null) {
            this.nickname = "anonymous@${(1..100).random()}"
        } else {
            this.nickname = nickname
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
        result = 31 * result + (nickname?.hashCode() ?: 0)
        return result
    }


}