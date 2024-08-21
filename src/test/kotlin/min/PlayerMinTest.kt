package min

import internal.study.kotlin.min.PlayerMin
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs

class PlayerMinTest : StringSpec({

    "플레이어의 이름과 닉네임을 입력받아 플레이어를 생성한다." {
        val player = PlayerMin("Minyeol", "min")
        player.name shouldBe "Minyeol"
        player.nickname shouldBe "min"
    }

    "닉네임을 입력하지 않는 경우 anonymous 닉네임을 자동으로 할당한다." {
        val player = PlayerMin(name = "Minyeol")

        val actual = player.nickname.split("@")
        player.name shouldBe "Minyeol"
        actual[0] shouldBe "anonymous"
        actual[1].toInt() shouldBeInRange 1..100
    }

    "이름과 닉네임이 같은 플레이어는 동일한 플레이어이다" {
        val player1 = PlayerMin("Minyeol", "min")
        val player2 = PlayerMin("Minyeol", "min")

        player1 shouldBeEqual player2
    }

    "범위연산자(..)는 마지막 값을 포함한다." {
        val int = (0..5).random()
        int shouldBeInRange 0..5
    }

    "until 연산자는 마지막 값을 포함하지 않는다." {
        val int = (0 until 5).random()
        int shouldBeInRange 0..4
    }

    "step loops는 step 값 만큼 증가시킨다" {
        val expectedValues = listOf(0, 2, 4, 6)
        val actualValues = mutableListOf<Int>() // 가변리스트

        for (i in 0..6 step 2) {
            actualValues.add(i)
        }

        actualValues shouldBe expectedValues
    }
})
