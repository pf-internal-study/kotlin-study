package internal.study.kotlin.son.day2

class Dice {
    private var eyes: Int? = null

    fun roll(): Int {
        return (1..6).random()
    }
    fun view(): Int {
        return eyes ?: throw IllegalStateException("주사위를 굴려주세요.")
    }

}