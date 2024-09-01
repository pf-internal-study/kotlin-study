package chim

import internal.study.kotlin.chim.Game
import internal.study.kotlin.chim.Player
import internal.study.kotlin.chim.Round
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe

class Day3Mission: BehaviorSpec({

    Given("게임 초기화 단계에서") {
        When("라운드를 생성하면") {
            val round = Round(1)
            Then("기록지는 비어있고, 승자는 없다") {
                round.id shouldBe 1
                round.records shouldHaveSize 0
                round.winner shouldBe null
            }
        }

        When("게임을 생성하면") {
            val game = Game()
            Then("10개의 비어있는 라운드를 생성한다") {
                game.rounds.forEach {
                    println(it.id)
                }
                game.rounds shouldHaveSize 10
            }

            Then("참여 플레이어 목록은 비어있다") {
                game.players shouldHaveSize 0
            }

            Then("최종 우승자는 없다") {
                game.winner shouldBe null
            }
        }

        When("게임에 플레이어가 참여하면") {
            val game = Game()
            Then("게임 플레이어 목록에 추가된다") {
                val player = Player("성현석", "침")
                val other = Player("대니스", "초대손님")
                game.join(player)
                game.join(other)

                game.players shouldHaveSize 2
                game.players shouldContainAll listOf(player, other)
            }
        }

        When("게임에 플레이어가 중복 참여하면") {
            val game = Game()
            Then("예외가 발생한다") {
                val player = Player("성현석", "침")
                val other = Player("성현석", "침")
                game.join(player)
                val exception = shouldThrow<IllegalStateException> {
                    game.join(other)
                }

                exception.message shouldBe "중복 지원할 수 없습니다."
            }
        }
    }
})
