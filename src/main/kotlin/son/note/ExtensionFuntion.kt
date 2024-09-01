package internal.study.kotlin.son.note

fun String.first() : Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}

// 확장 함수와 같은 함수명이 있을 경우 Class 내부 함수가 우선순위가 높다.
class MyExample {
    fun printMessage(message: String) = println("Class method : $message")
}

fun MyExample.printMessage(message: String ) = println("Extension function")

fun MyExample.printMessage() = println("No params Extension function")

fun MyExample?.printNullOrNotNull() {
    if (this == null) println("null 경우에만 출력")
    else println("null이 아닌 경우에만 출력")
}


fun main() {
    println("ABCD".first())

    println("ABCD".addFirst('Z'))

    MyExample().printMessage("안뇽")
    MyExample().printMessage()

    var myExample : MyExample? = null
    MyExample().printNullOrNotNull()

    myExample = MyExample()
    myExample.printNullOrNotNull()


}