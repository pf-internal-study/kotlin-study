package internal.study.kotlin.son.note

/**
 * 함수는 일급 객체로 취급된다.
 * 함수를 변수에 저장할 수 있고, 함수의 인자로 전달할 수 있으며, 함수의 반환값으로 사용할 수 있다.
 *
 * 함수도 타입이다.
 * fun, val 선언했을 때 다른점이 있음 val 은 함수를 변수에 저장할 수 있음
 * fun 일급함수가 아님
 * */

// Unit 은 반환 값
//val func : () -> Unit = {}
//val func: () -> String = { "" }
val printHello: () -> Unit = { println("Hello") }
fun call (block: () -> Unit) { block() }
fun printNo() = println("No!")
// (String) 이건 함수의 인자가 String, Unit 이건 반환 값, message 는 함수의 인자
val printMessage: (String) -> Unit = { message: String -> println(message) }
// 위랑 같은거
val printMessage2: (String) -> Unit = { println(it) }

val plus: (Int, Int) -> Int = { a, b -> a + b }
val plus2: (Int, Int, Int) -> Int = { a, b, c -> a + b + c }

// 고차 함수
fun forEachStr(collection: Collection<String>, action: (String) -> Unit ) {
    for (item in collection) {
        action(item)
    }
}

// 익명 함수
//fun outerFunc() : () -> Unit {
//    return fun () {
//        println("이것은 익명함수")
//    }
//}
//fun outerFunc() : () -> Unit {
//    return {
//        println("이것은 익명함수")
//    }
//}
fun outerFunc() { println("이것은 익명함수") }

// 람다 표현식의 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

// 최대한 생략한 람다 식
val sum2 = { x: Int, y: Int -> x + y }

fun arg1(block: (String) -> Unit) {}
fun arg2(block: (String, String) -> Unit ) {}

fun main() {
    val list = mutableListOf(printHello)
    val func1 = list[0]
    func1()
    val func2: () -> Unit = list[0]
    func2()

    println(list)

    call(printHello)

    val func = printNo()
    // 아래 두개 불가능
//    val list = mutableListOf(printNo())
//    call(printNo())

    // but 이건 가능 왜냐하면 함수를 반환하는 것이기 때문에
    call { printNo() }

    val result = plus(1,3)
    println(result)

    val result2 = plus2(1,3,5)
    println(result2)
    println("------------")
    val list2 = listOf("a", "b", "c")
    val printStr: (String) -> Unit = { println(it) }

    // list2 값 넘겨줌 action(item) 결국 위 printStr 하나 하나씩 실행하는 결과임
    forEachStr(list2, printStr)
    println("------------1")
    val upperCase: (String) -> Unit = {
        it.uppercase().also { println(it) }
    }
    forEachStr(list2, upperCase)
    println("------------2")

    // 익명 함수
    outerFunc()
    println("------------3")
    sum(1,2)
    sum2(3,2)

    arg1 {
        it.length
        it.first()
    }

    // 인자가 2개 이상 일 경우 it 사용 불가능
    arg2 { a: String, b: String ->
        a.length
        b.first()
    }

    println("------------4")
    val callReference : () -> Unit = { printHello() }
    callReference()

    println("------------5")
    // 람다 레퍼런스 문법
    val callReference2 = ::printHello
    callReference2()()

    println("------------6")
    val numberList = listOf("1", "2", "3")
    numberList.map { it.toInt() }.forEach { println(it) }
    println("------------7")
    // 이렇게 변경가능
    numberList.map(String::toInt).forEach(::println)

    // arrow 라는 라이브러리 사용하면 더 간단하게 사용 가능 https://arrow-kt.io/docs/core

}