package internal.study.kotlin.son.note

class DatabaseClient {
    var url: String? = null
    var userName: String? = null
    var password: String? = null

    fun connect(): Boolean {
        println("DB 접속중 ...")
        Thread.sleep(1000)
        println("DB 접속 성공")

        return true
    }
}

fun main() {
//    val config = DatabaseClient()
//    config.url = "jdbc:mysql://localhost:3306/test"
//    config.userName = "root"
//    config.password = "1234"
//    val connected = config.connect()

    /**
     * run 을 사용하면 객체를 생성하고 바로 초기화 할 수 있다.
     * run 은 마지막 표현식을 반환한다.
     * run 은 객체를 생성하고 반환하는 코드를 작성할 때 사용한다.
     * 프로퍼티 앞에 this 가 생략되어있음
     * */

    val connected: Boolean = DatabaseClient().run {
        url = "jdbc:mysql://localhost:3306/test"
        userName = "root"
        password = "1234"

        connect()
    }

    println("connected : $connected")

    // let 으로 할 수 있음 하지만 앞에 it 붙어야함.
    val connected2: Boolean = DatabaseClient().let {
        it.url = "jdbc:mysql://localhost:3306/test"
        it.userName = "root"
        it.password = "1234"

        it.connect()
    }
    println(connected2)

    // with 으로 할 수 있음 하지만 앞에 it 붙어야함.
    val connected3: Boolean = with(DatabaseClient())  {
        this.url = "jdbc:mysql://localhost:3306/test"
        this.userName = "root"
        this.password = "1234"

        this.connect()
    }
    println(connected3)

}