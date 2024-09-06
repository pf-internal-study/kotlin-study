package internal.study.kotlin.son.note

class HelloBot {

//    var greeting: String? = null
    /**
        by lazy 를 사용하면 val 로 선언해야 한다.
        by lazy 최초 한번만 초기화 함
        멀티스레드에서 안전하다.

        by lazy(LazyThreadSafetyMode.NONE) : 멀티스레드에서 안전하지 않다.


    */
    val greeting: String by lazy {
        println("초기화 됨 111")
        getHello()
    }
    fun sayHello() = println(greeting)
}

fun getHello(): String {
    println("초기화 됨 2222")

    return "안녕하세요."
}

fun main() {
    val helloBot = HelloBot()

    // ...
    // ...

    // helloBot.greeting = getHello()
//    helloBot.sayHello()
//    helloBot.sayHello()
//    helloBot.sayHello()

    for (i in 1..3) {
        Thread {
            helloBot.sayHello()
        }.start()
    }

}