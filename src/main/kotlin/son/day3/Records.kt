package internal.study.kotlin.son.day3

//라운드 > 기록지 > 플레이어
/*
기록지(records)에는 플레이어마다 해당 라운드에 던진 5개 주사위의 눈금 결과가 기록된다.
라운드가 가지는 기록지는 1개이며, 기록지 1개에 여러 플레이어의 기록이 담겨있다.
라운드가 생성될 때 기록지는 비어있다. (empty)
*/

class Records(private val player: Player) {
    private val _dices = mutableListOf<DiceEyes>()

    val playerName: String
        get() = player.name

    fun add(eyes: DiceEyes) {
        check(_dices.size < MAX_DICE) { NOT_ROLL_MAX_DICE }
        _dices.add(eyes)
    }

    fun sum(): Int {
        return _dices.sumOf { it.eyes }
    }

    companion object {
        private const val MAX_DICE = 5
        private const val NOT_ROLL_MAX_DICE = "주사위는 5개까지만 던질 수 있습니다."
    }
}