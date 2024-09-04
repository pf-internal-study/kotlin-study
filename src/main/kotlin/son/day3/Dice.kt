package internal.study.kotlin.son.day3

class Dice {
    private val _eyes: DiceEyes? = null

    fun roll(): DiceEyes {
        return DiceEyes.of((1..6).random())
    }

    fun view(): DiceEyes {
        return _eyes ?: throw IllegalStateException("주사위를 굴려주세요.")
    }
}