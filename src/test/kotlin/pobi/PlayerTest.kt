package pobi

import internal.study.kotlin.pobi.Player
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PlayerTest : StringSpec({
    "닉네임을 입력하지 않으면 자동으로 생성된다" {
        val actual = Player("jimmy" )
        actual.nickname.split("@")[0] shouldBe "anonymous"
    }

    "플레이어는 이름과 닉네임을 가지고 있다" {
        val actual = Player("jimmy", "pobi" )
        actual.name shouldBe "jimmy"
        actual.nickname shouldBe "pobi"
    }


    "플레이어들의 이름과 닉네임이 같다면 같은 플레이어이다" {
        val actual = Player("jimmy", "pobi" )
        val copy = actual.copy()
        actual.name shouldBe copy.name
        actual.nickname shouldBe copy.nickname
        actual shouldBe copy
    }
})
