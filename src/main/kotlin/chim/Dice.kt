package internal.study.kotlin.chim

class Dice {
    /**
     * non null 타입의 변수를 사용하기 전엔 꼭 할당하겠다는 의미
     * 해당 변수를 사용하는 시점엔 무조건 할당이 되어 있기 때문에
     * 사용하는 곳에선 null 검증 비용을 줄일 수 있음
     * 할당 전에 사용하게 되면 UninitializedPropertyAccessException 오류 발생
     */
    private lateinit var eyes: DiceEyes

    fun roll(): Int {
        eyes = DiceEyes()
        return eyes.point
    }

    fun view(): Int = eyes.point
}
