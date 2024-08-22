package internal.study.kotlin.min

// 전역 변수 (어디서든 호출 가능)
const val GLOBAL_NOT_ROLLED_MESSAGE = "주사위를 아직 굴리지 않았습니다.2"

class DiceMin {
    private var eyes: Int? = null

    // 클래스 멤버 정적변수
    companion object {
        const val MEMBER_NOT_ROLLED_MESSAGE = "주사위를 아직 굴리지 않았습니다."
    }
    
    fun getEyes(): Int? {
        return this.eyes
    }

    fun roll(): Int {
        eyes = (1..6).random()
        //단언 연산자
        return eyes!!
    }

    fun view(): Int {
        return eyes ?: throw IllegalStateException(DiceMin.MEMBER_NOT_ROLLED_MESSAGE)
    }

    fun view2(): Any {
        // 코틀린 예외는 Nothing 타입으로 반환가능 (변수화 가능)
        return eyes ?: failView(GLOBAL_NOT_ROLLED_MESSAGE)
    }

    private fun failView(message: String) {
        throw IllegalStateException(message)
    }
}
