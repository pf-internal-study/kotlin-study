package internal.study.kotlin.son.note

class LateInit {
    /**
     * lateinit 을 사용하면 var 로 선언해야 한다.
     * 초기화를 나중에 할 수 있다.
     * 초기화 전에 사용하면 UninitializedPropertyAccessException 이 발생한다.
     *
     * lateinit 은 기본 자료형에는 사용할 수 없다.
     * lateinit 은 var 로 선언해야 한다.
     *
     * 특정 프레임워크나 라이브러리에서 초기화를 염두로 두고 사용한다.
     */
    lateinit var text: String

    val textInitialization: Boolean
        get() = this::text.isInitialized

    fun printText() = println(text)
}

fun main() {

    val test = LateInit()

    if (!test.textInitialization) {
        test.text = "안녕하세요."
    }

    test.printText()
}