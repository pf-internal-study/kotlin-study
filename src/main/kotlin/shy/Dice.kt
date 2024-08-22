package internal.study.kotlin.shy

class Dice {
    var eyes: Int? = null

    /***
     * 주사위는 주사위를 굴리는 기능
     * - 주사위를 굴리면 1~6 사이 숫자를 부여받고, 그 값을 외부로 반환한다.
     */
    fun roll(): Int {
        eyes = (1..6).random()
        return eyes!!
    }

    /**
     * 주사위를 굴려 나온 값을 볼 수 있는 기능
     * - 단 주사위를 굴리기 전엔 볼 수 없다.
     */
    fun view(): Int {
        if (eyes == null) {
            throw Exception("주사위를 먼저 굴려주세요.")
        }
        print("현재 주사위 눈금은 $eyes 입니다.")
        return eyes!!
    }
}
