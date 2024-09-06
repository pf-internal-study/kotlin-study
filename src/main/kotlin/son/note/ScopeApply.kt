package internal.study.kotlin.son.note

fun main() {

    /**
     * 컨텍스트 객체의 내부 속성을 변경하는 것이 목적이라면 apply를 사용한다.
     * apply는 컨텍스트 객체를 반환한다.
     *
     *
     */
    val client: DatabaseClient = DatabaseClient().apply {
        url = "jdbc:mysql://localhost:3306/test"
        userName = "root"
        password = "1234"

        connect() // 주소값 찍힘
    }
    println(client)
    client.connect().run { println(this) }


    // 추천하지는 않지만 체이닝으로도 사용가능
    DatabaseClient().apply {
        url = "jdbc:mysql://localhost:3306/test"
        userName = "root"
        password = "1234"
    }.run {
        println(this)
    }

}
