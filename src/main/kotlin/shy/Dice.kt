package internal.study.kotlin.shy

class Dice {
    var eyes: Int? = null

    constructor() {}

    fun roll(): Int {
        eyes = (1..6).random()
        return eyes as Int
    }

    fun view() {
        if (eyes == null) {
            throw Exception("주사위를 먼저 굴려주세요.")
        }
        print("주사위 눈금은 $eyes 입니다.")
    }
}
