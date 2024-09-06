package internal.study.kotlin.son.note

class MyGenerics<out T>(val t : T)

class Bag<T> {
    fun saveALL(to: MutableList<in T>, from : MutableList<T>) {
        to.addAll(from)
    }
}

fun main () {

    // 제네릭을 사용한 클래스의 인스턴스를 만드려면 타입아규먼트로 제공
//    val generics = MyGenerics<String>("테스트")
//    val charGenerics = MyGenerics<CharSequence> = generics
//    -------------------------
//    // 생략 가능
//    val gennerics = MyGenerics("테스트")
//
//    // 변수의 타입에 제네릭을 사용하는 경우
//    val list : MutableList<String> = mutableListOf()
//
//    // 타입 아규먼트를 생성자에 추가
//    val list2 = mutableListOf<String>()
//
//    val list3 : List<*> = listOf<Int>(1, 4, 5)
//
//    val list4 : List<*> = listOf<String>("1", "4", "5")
//
//    val list5 : List<*> = listOf(1, "A", 3.0)


    // PECS 는 producer-Extends, Consumer-Super
    // 공변성은 자바 제네릭의 extends 코틀린에선 out
    // 반공변성은 자바 제네릭의 super 코틀린에선 in

    val bag = Bag<String>()
    bag.saveALL(mutableListOf<CharSequence>("1","2"), mutableListOf<String>("3","4"))

}