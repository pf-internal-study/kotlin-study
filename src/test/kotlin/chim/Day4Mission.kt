package chim

import internal.study.kotlin.chim.Game
import internal.study.kotlin.chim.Player
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe


class Day4Mission: BehaviorSpec({

    Given("플레이어는") {
        val player = Player("성현석", "침")
        val game = Game()
        When("게임에 참여하기 전엔") {
            Then("주사위를 갖고 있지 않는다") {
                val actual = player.hasDice()
                actual shouldBe false
            }
        }

        When("게임에 참여하면") {
            game.join(player)
            Then("주사위 5개를 지급 받는다") {
                val actual = player.hasDice()
                actual shouldBe true
            }
        }
    }

})
