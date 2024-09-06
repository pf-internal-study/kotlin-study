package internal.study.kotlin.son.note

// f((1,3)) = 1 + 3 =4
// f(1,3) = 1 + 3 = 4
//fun plus(a: Int, b: Int) = a + b

//data class Tuple(val a : Int, val b: Int)
//fun plus(tuple: Tuple) = tuple.a + tuple.b

fun plus(pair: Pair<Int,Int>) = pair.first + pair.second

fun main() {
//    println(plus(1,3))
    val plus = plus(Pair(1,3))
    println(plus)

    val pair = Pair("A",3)
    val newPair = pair.copy(first = "B")

    println(newPair)

    val second = newPair.component2()
    println(second)

    val list = newPair.toList() // immutable
    println(list)

    val triple = Triple("A", 1, 3.0)
    println(triple)

    triple.first
    triple.second
    triple.third
    // triple.third = "D" // 안됨
    val newTriple = triple.copy(third = 4.0)
    println(newTriple)
    println(newTriple.component3())

    // 구조분해 javascript 처럼 사용 - 타입 생략 가능
    val (tripleFirst: String, tripleSecond: Int, tripleThird) = newTriple
    println("tripleFirst : $tripleFirst, tripleSecond : $tripleSecond, tripleThird : $tripleThird")

    // list는 최대 5개 - list3.component5()
    val list3 = newTriple.toList()
    val (list3First, list3Second, list3Third) = list3
    println("list3First : $list3First, list3Second : $list3Second, list3Third : $list3Third")

    // map 구조분해 가능 - 애도 Pair 로 구성
    val map1 = mutableMapOf(Pair("손","son"), "이" to "lee")
    val map = mutableMapOf("손" to "son", "이" to "lee")

    for ((key, value) in map) {
        println("key : $key, value : $value")
    }

}