package son.day3

import internal.study.kotlin.son.day3.Dice
import internal.study.kotlin.son.day3.Game
import internal.study.kotlin.son.day3.Player
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

/*라운드 (Round)
라운드는 기록지와 라운드 승자 플레이어를 가진다.
기록지(records)에는 플레이어마다 해당 라운드에 던진 5개 주사위의 눈금 결과가 기록된다.
라운드가 가지는 기록지는 1개이며, 기록지 1개에 여러 플레이어의 기록이 담겨있다.
라운드가 생성될 때 기록지는 비어있다. (empty)
승자(winner)는 라운드가 종료될 때, 가장 높은 점수를 받은 플레이어로 결졍된다.
승자가 정해지기 전까지 승자는 없다.

게임 (Game)
게임은 진행될 라운드(rounds)와 참여할 플레이어(players) 그리고 최종 우승자(winner)를 가진다.
게임은 10라운드로 이루어져 있다.
게임이 시작된 후 라운드 목록은 변경할 수 없다.
게임은 플레이어의 참가 지원을 받는 기능(join)이 있다.
지원한 플레이어는 참여 플레이어 (players)에 등록된다.
동일한 플레이어는 지원할 수 없다.
최종 우승자(winner)는 게임이 종료될 때, 가장 많은 라운드를 승리한 플레이어로 결정된다.
최종 우승자가 정해지기 전까지 우승자는 없다.*/

class Day3Mission2 : BehaviorSpec({
    Given("게임은 기본적으로 진행될 라운드(rounds) 10개를 가진다.") {
        val game = Game(10)
        Then("게임 객체는 null 없다.") {
            game shouldNotBe null
        }

        When("사람이 Join 하지 않는 상태에 게임을 세팅하면") {
            Then("참가한 플레이어가 없습니다. 라는 에러를 반환한다.") {
                shouldThrow<IllegalStateException> {
                    game.set()
                }.message shouldBe "참가한 플레이어가 없습니다."
            }
        }

        When("게임 시작 전 게임 종료 시 ") {
            Then("게임이 시작되지 않았습니다. 라는 에러를 반환한다.") {
                shouldThrow<IllegalStateException> {
                    game.finish()
                }.message shouldBe "게임이 시작되지 않았습니다."
            }
        }

        val player = Player("son",null)
        game.join(player)

        When("게임에 참가한 플레이어가 동일한 플레이어일 경우") {

            Then("동일 플레이어가 참여 시 '이미 참가한 플레이어입니다.' 라는 에러를 반환한다. ") {
                shouldThrow<IllegalStateException> {
                    game.join(player)
                }.message shouldBe "이미 참가한 플레이어입니다."
            }
        }

        val player2 = Player("chim", "chim")
        val player3 = Player("min", "min")
        val player4 = Player("shy", "shy")
        val player5 = Player("pobi", "pobi")

        game.join(player2)
        game.join(player3)
        game.join(player4)
        game.join(player5)

        game.set()

        game.playRound()

        game.finish()

        Then("게임이 종료되면 최종 우승자가 정해진다.") {
            game.winner shouldNotBe null

        }
    }
})