package internal.study.kotlin.son.note

/*
// 불변성
data class Person(val name: String, val age: Int)

fun main () {
    val person1 = Person("son", 30)
//    val person2 = Person("son", 30)

    // 기존 데이터를 갖고오고 새로운 객체 만들 때 copy 사용
    val person2 = person1.copy(name = "son2")

    println(person1 == person2)

    val set = hashSetOf(person1)
    println(set.contains(person2))

    println(person1)

    // 컴포넌트 any
    println("이름 : ${person1.component1()}, 나이 : ${person1.component2()}")
    val (name, age) = person1
    println("이름 : $name, 나이 : $age")
}
*/

/* 싱글톤 */
//object DateTimeUtil {
//    val now : LocalDateTime
//        get() = LocalDateTime.now()
//
//    const val DEFAULT_FORMAT = "yyyy-MM-dd"
//
//    fun same(a: LocalDateTime, b: LocalDateTime) : Boolean {
//        return a == b
//    }
//}
//
//fun main() {
//    println(DateTimeUtil.now)
//    println(DateTimeUtil.now)
//    println(DateTimeUtil.now)
//
//    println(DateTimeUtil.DEFAULT_FORMAT)
//
//    val now = LocalDateTime.now()
//    println(DateTimeUtil.same(now, now))
//}

class MyClass private constructor() {

    companion object {
        val a = 1234
        fun newInstance() = MyClass()
    }
}

fun main () {
    println(MyClass.a)
    println(MyClass.newInstance())

    println(MyClass.a)
    println(MyClass.newInstance())
}

/**
 * */
/*
fun main () {

    val linkedList = LinkedList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    val lowerList = listOf("a", "b", "c")
    val upperList = mutableListOf<String>()

//        for (low in lowerList) {
//            upperList.add(low.uppercase())
//        }

//        println(upperList)

    val upperResult = lowerList.map { it.uppercase() }
    println(upperResult)
    println(lowerList)

    // ****************************

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

//        val result = mutableListOf<Int>()
//        for (i in list) {
//            when {
//                i % 2 == 0 -> result.add(i)
//            }
//        }
//        println(result)


    // 인라인 함수 체인이 많아지면 하나씩 생성됨 -> 메모리 낭비
    */
/*
    val result = list
        .filter { it % 2 == 0 }
        .filter { it % 3 == 0 }
        .filter { it % 4 == 0 }
    *//*


    // 다루는 데이터 양이 많아진다 or 체인이 많아질 경우 -> asSequence() 사용
    // 5만건 10만건 정도면 asSequence 사용 하지 않는게 좋음
    val result = list
        .asSequence()
        .filter { it % 2 == 0 }
        .filter { it % 3 == 0 }
        .toList()

    println(result)
}*/
