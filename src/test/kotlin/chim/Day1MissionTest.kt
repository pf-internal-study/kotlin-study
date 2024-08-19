package chim

import internal.study.kotlin.chim.Player
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.equals.shouldNotBeEqual
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class Day1MissionTest : StringSpec({

    "플레이어의 이름과 닉네임은 생성자에 할당 받은 값이다" {
        val player = Player("성현석", "침")

        player.name shouldBe "성현석"
        player.nickname shouldBe "침"
    }

    "플레이어의 닉네임은 입력하지 않는 경우 자동부여 닉네임을 할당 받는다" {
        val player = Player(name = "성현석")

        val actual = player.nickname.split("@")
        actual[0] shouldBe "anonymous"
        actual[1].toInt() shouldBeInRange 1..100
    }

    "이름과 닉네임이 같은 플레이어는 동일한 플레이어이다" {
        val player = Player("성현석", "침")
        val other = Player("성현석", "침")
        val copied = player.copy() // data class 기본제공

        player shouldBeEqual other
        player shouldBeEqual copied
        other shouldBeEqual copied
    }

    "이름과 닉네임 중 하나라도 다른 플레이어는 다른 플레이어이다" {
        val player = Player("성현석", "침")
        val copied = player.copy(nickname = "침착맨빠돌이")

        player shouldNotBeEqual copied
    }
})
