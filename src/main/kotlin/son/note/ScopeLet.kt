package internal.study.kotlin.son.note

fun main() {
    var str: String? = "안녕"

    // let null 이 아닐 경우에만 출력
    val result: Int? = let(str)

    println(result)
}

/**
 * let 은 언제 사용하나?
 * null 이 아닐 때만 코드를 실행할 때 사용한다.
 * let 은 마지막 표현식을 반환한다.
 * let 은 null 체크를 할 때 사용한다.
 * let 은 null 이 아닐 때만 코드를 실행할 때 사용한다.
 *
 * 장점 : null 체크를 할 필요가 없다.
 * 단점 : 중첩이 많아지면 가독성이 떨어진다.
 *
 * */
// 이렇게 많이 중첩되는 경우에는 걍 if else 사용하자
private fun let(str: String?): Int? {
    val result: Int? = str?.let {
        println(it)

//        val abc: String? = "abc"
//
//        abc?.let {
//            val def: String? = "def"
//            def?.let {
//                println("abcdef 가 아님")
//            }
//        }
//        1234

        val abc: String? = "abc"
        val def: String? = "def"

        if (!abc.isNullOrEmpty() && !def.isNullOrEmpty()) {
            println("abcdef 가 아님")
        }

        1234
    }
    return result
}