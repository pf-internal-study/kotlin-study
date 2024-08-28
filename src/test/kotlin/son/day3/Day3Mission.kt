package son.day3

import internal.study.kotlin.son.day3.Game
import internal.study.kotlin.son.day3.Player
import io.kotest.assertions.throwables.shouldThrow
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

class Day3Mission : StringSpec({

    "게임은 기본적으로 진행될 라운드(rounds) 10개를 가진다." {
        val Game = Game()
        Game shouldNotBe null
    }

    "게임은 재 시작 할 수 없다." {
        val game = Game()
        val player = Player("son", "son")

        game.join(player)

        game.start()

        shouldThrow<IllegalArgumentException> {
            game.start()
        }.message shouldBe "이미 시작된 게임입니다."
    }

    "지원한 플레이어는 참여 플레이어 (players)에 등록되며 같은 사람이 참여 할 수 없다." {
        val game = Game()
        val player = Player("son", "son")

        game.join(player)

        game.start()

        shouldThrow<IllegalArgumentException> {
            game.join(player)
        }.message shouldBe "이미 참가한 플레이어입니다."
    }

    "라운드는 기록지와 라운드 승자 플레이어를 가진다." {
        val game = Game()
        val player = Player("son", "son")
        val player2 = Player("chim", "chim")

        var players = mutableListOf(player, player2)

        game.join(players)

        val round = game.getRounds()
        round shouldNotBe null
    }
})