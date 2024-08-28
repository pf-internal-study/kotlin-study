package internal.study.kotlin.pobi

class Record {
    private var _dices: MutableList<Dice> = mutableListOf()

    private var player: Player? = null

    fun addDice(dice: Dice) {
        if (_dices.size > 5) {
            throw Exception("주사위는 최대 5번까지 굴릴수 있습니다.")
        }
        _dices.add(dice)
    }

    fun getTotalDices(): Int {
        return _dices.sumOf { it.eyes!! }
    }

    fun getPlayer(): Player? {
        return player
    }

    fun getDices(): List<Dice> {
        return _dices.toList();
    }
}
