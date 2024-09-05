package internal.study.kotlin.son.note

fun main() {
    val str = "안녕하세요."

    /**
     * with 확장 함수가 아님
     * with 는 객체를 this 로 받아서 사용한다.
     * run 이랑 비슷함
     * */
    val length = with(str) {
        length
    }

    println(length)
}