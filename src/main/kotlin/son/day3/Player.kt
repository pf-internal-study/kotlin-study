package internal.study.kotlin.son.day3

class Player(
    val name: String,
    var nickname: String?
) {
    private val _winCount: Int = 0

    init {
        this.nickname = nickname ?: "anonymous@${(1..100).random()}"
    }

    fun win() {
        _winCount.inc()
    }

    fun winCount(): Int {
        return _winCount
    }
}