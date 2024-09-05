import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.util.*

class TestSample : StringSpec({

    "1+1은 2다" {
        val actual: Int = 1 + 1
        actual shouldBe 2
    }

    "LinkedList의 size는 0이다" {
        val linkedList = LinkedList<Int>().apply {
            add(1)
            add(2)
            add(3)
        }
        linkedList.size shouldBe 3
    }

    "list low -> upper" {
        val lowerList = listOf("a", "b", "c")
        val upperList = mutableListOf<String>()

//        for (low in lowerList) {
//            upperList.add(low.uppercase())
//        }

//        println(upperList)

        val upperResult = lowerList.map { it.uppercase() }
        println(upperResult)
        println(lowerList)
    }

    "list filter" {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

//        val result = mutableListOf<Int>()
//        for (i in list) {
//            when {
//                i % 2 == 0 -> result.add(i)
//            }
//        }
//        println(result)


        // 인라인 함수 체인이 많아지면 하나씩 생성됨 -> 메모리 낭비
        /*
        val result = list
            .filter { it % 2 == 0 }
            .filter { it % 3 == 0 }
            .filter { it % 4 == 0 }
        */

        // 다루는 데이터 양이 많아진다 or 체인이 많아질 경우 -> asSequence() 사용
        // 5만건 10만건 정도면 asSequence 사용 하지 않는게 좋음
        val result = list
            .asSequence()
            .filter { it % 2 == 0 }
            .filter { it % 3 == 0 }
            .toList()

        println(result)
    }
})