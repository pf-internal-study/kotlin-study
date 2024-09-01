package internal.study.kotlin.son.note

fun getStr(): Nothing = throw Exception("예외 발생 기본 값으로 초기화")

fun main() {
//    FileWriter("test.txt")
//        .use {
//            it.write("Hello, World!")
//        }
    // ------------------------------
//    val result = try {
//        getStr()
//    } catch (e: Exception) {
//        println(e.message)
//        "기본 값111"
//    }
//  println(result)

    /**
     * runCatching
     * 장점 : 예외 처리를 람다식으로 처리 가능
     *
     * */
    val result = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본 값2222"
        }

    println(result)

    val result2 = runCatching { getStr() }
        .getOrNull()

    println(result2)

//    val result3 = runCatching { getStr() }
//        .exceptionOrNull()
//
//    result3?.let {
//        println(it.message)
//        throw it
//    }

    val result4 = runCatching { getStr() }
        .getOrDefault("기보오오오온 값")
    println(result4)

    val result5 = runCatching { "안녕" }
        .map { "${it}하세요!!!!" }
        .getOrThrow()
    println(result5)

    // 이러면 map 에서 터지고 getOrDefault 로 안넘어감. 예외!!! 터짐
//    val result6 = runCatching { "안녕" }
//        .map {
//            throw Exception("예외!!!")
//        }.getOrDefault("기본값아아아")
//    println(result6)

    // mapCatching 으로 사용하면 예외 발생해도 getOrDefault 로 넘어감
    val result7 = runCatching { "안녕" }
        .mapCatching {
            throw Exception("예외!!!")
        }.getOrDefault("기본값아아아")
    println(result7)


    // 실패 시 로직을 작성하던지 for 돌린다던지 할 수 있음
    val result8 = runCatching { getStr() }
        .recover {
            println(it.message)
            "복구"
        }
        .getOrNull()
    println(result8)

    // 이것도 recoverCatching 있음
    val result9 = runCatching { getStr() }
        .recoverCatching {
            throw Exception("에러!!발생!!")
        }
        .getOrDefault("에러 기본값으로 변경!")
    println(result9)
}