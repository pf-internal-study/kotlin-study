package internal.study.kotlin.pobi

class Player(
    val name: String,
    val nickname: String = "anonymous@" + (1..100).random(),
) {
    private lateinit var dices: List<Dice>

    /*
    * 게임 입장시 주사위 5개 지급
    * */
    fun setDices() {
        this.dices = List(5) { Dice() }
    }
    fun rollDices() {
        dices.forEach { it.roll() }
    }

    fun getTotalEyes(): Int {
        return dices.sumOf { it.view()!! }
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
        result = 31 * result + dices.hashCode()
        return result
    }

}

/**
 * 생성자 호출 순서
 * 1. 주 생성자
 * 2. init 블록
 * 3. 보조 생성자
 */
