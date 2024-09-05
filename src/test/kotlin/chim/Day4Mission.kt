package chim

import internal.study.kotlin.chim.Game
import internal.study.kotlin.chim.Player
import internal.study.kotlin.chim.Round
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeOneOf
import io.kotest.matchers.collections.shouldHaveSize
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

        When("주사위를 굴리면") {
            Then("주사위 5개 굴려서 얻은 결과를 반환한다") {
                val actual = player.rollDice()
                actual shouldHaveSize 5
            }
        }
    }

    Given("라운드는") {
        val game = Game()
        listOf(
            Player("성현석", "침"),
            Player("손민기", "손"),
            Player("남상이", "생이"),
            Player("이민열", "민"),
            Player("이재근", "샤이"),
            Player("유진탁", "포비"),
        ).forEach { game.join(it) }

        When("플레이어를 전달받아 라운드를 시작하면") {
            val round = Round(1)
            Then("참여한 플레이어 중 1명의 승자를 반환한다") {
                val actual = round.run(game.players)

                actual shouldBeOneOf game.players
                actual shouldBe round.winner
                println("라운드 승자: $actual")
            }
        }
    }
})
