package internal.study.kotlin.son.note

class User(val name: String, val password: String) {
    fun validate() {
        if (name.isNotEmpty() && password.isNotEmpty()) {
            println("유효성 검사 통과")
        } else {
            println("유효성 검사 실패")
        }
    }

    fun printName() = println(name)
}

fun main() {
    val user: User = User(name = "son", password = "1234")
    user.validate()

    /**
     * also 부수 작업을 수행한거나 전달 받은 객체를 반환한다.
     * 컨텍스트 내부 내용을 it 으로 간결하게 사용 가능
     *
     * ************************
     * Scope 함수 유의할 점
     * 실무에서는 섞어서 쓰는 경우도 많음, 다양한 방법이 많음 그러므로 팀 내 컨벤션을 따라간다.
     * this, it 차이점이있음
     *
     * this : apply, run, also
     * it : let, also
     *
     * this 는 키워드, 예약어
     * it 소프트키워드
     * */
    val user2: User = User(name = "son", password = "1234").also {
        it.validate()
        it.printName()
    }

    val hello = "hello"
    val hi = "hi"

    // 가독성 안좋음 추천하지 않음
//    hello.let {
//        println(it.length)
//
//        hi.let {
//            println(it.length)
//        }
//    }

    // 차라리 이렇게 지정해서 써라!
    hello.let { a: String ->
        println(a.length)
        hi.let { b->
            println(b.length)
        }
    }



}