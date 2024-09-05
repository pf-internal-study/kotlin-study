package internal.study.kotlin.son.note

sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("나는 백엔드 개발자입니다. $language 언어로 개발합니다.")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("나는 프론트엔드 개발자입니다. $language 언어로 개발합니다.")
    }
}

data class AndroidDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("나는 안드로이드 개발자입니다. $language 언어로 개발합니다.")
    }
}

object OtherDeveloper : Developer() {
    override val name: String = "익명"

    override fun code(language: String) {
        TODO("Not yet implemented")
    }

}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when (developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        is AndroidDeveloper -> pool[developer.name] = developer

        is OtherDeveloper -> println("익명 개발자는 추가할 수 없습니다.")
//        else -> println("지원하지않는 개발자입니다.") // 추상 클래스를 sealed 바꾸면 else 가 필요없음
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper("손")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper("토니")
    DeveloperPool.add(frontendDeveloper)

    val androidDeveloper = AndroidDeveloper("엘리")
    DeveloperPool.add(androidDeveloper)

    println(DeveloperPool.get("손"))
    println(DeveloperPool.get("토니"))

}

