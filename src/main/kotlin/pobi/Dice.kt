package internal.study.kotlin.pobi

class Dice {
    var eyes: Int? = null

    init {
        print("주사위 생성 eyes 값 초기화")
        this.eyes = null
    }

    fun roll(): Int {
        this.eyes = (1..6).random()
        return this.eyes!!
    }

    /*
    * 변수에 ? 사용은 null을 허용한다는 뜻
    * 변수의 !! 사용은 null 을 허용한 값이 null이 아니다라는 표현을 함으로 컴파일시 에러를 방지
    * */
    fun view(): Int? {
        return this.eyes
    }
}


