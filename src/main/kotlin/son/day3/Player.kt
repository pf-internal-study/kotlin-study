package internal.study.kotlin.son.day3

class Player(
    val name: String,
    var nickname: String?
) {
    private var _winCount: Int = 0

    val winCount: Int
        get() = _winCount

    init {
        this.nickname = nickname ?: "anonymous@${(1..100).random()}"
    }

    fun win() {
        _winCount++
    }
}