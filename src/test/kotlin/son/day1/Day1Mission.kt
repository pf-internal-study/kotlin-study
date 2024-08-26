package son.day1

import internal.study.kotlin.son.day1.Player
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day1Mission : StringSpec({

    "플레이어는 이름과 닉네임을 입력 받을 수 있어야한다." {
        val player = Player("SonMinKi", "Son")

        player.name shouldBe "SonMinKi"
        player.nickname shouldBe "Son"
    }

    "플레이어 이름은 필수 이며 닉네임을 받지 않을 경우 anonymous@ + 1~100 사이의 난수를 닉네임으로 부여 받는다" {
        val player = Player("SonMinKi", null)

        player.name shouldBe "SonMinKi"
        player.nickname?.startsWith("anonymous@") shouldBe true
    }


    "플레이어의 이름과 닉네임이 같은 경우 동일한 플레이어로 간주한다." {
        val player = Player("SonMinKi", "Son")
        val anotherPlayer = Player("SonMinKi", "Son")

        player shouldBe anotherPlayer
    }

})