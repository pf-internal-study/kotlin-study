package shy

import internal.study.kotlin.shy.Game
import internal.study.kotlin.shy.Player
import internal.study.kotlin.shy.Round
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class Day3Mission: StringSpec ({
    "라운드는 기록지와 라운드 승자를 가진다." {
        val round = Round();

        round.records shouldBe emptyMap()
        round.winner shouldBe null
    }

    "게임은 라운드와 플레이어, 우승자를 가진다." {
        val game = Game()

        game.winner shouldBe null
        game.players shouldBe emptyList()
        game.rounds shouldBe emptyList()
    }

    "플레이어는 게임에 참가할 수 있다." {
        val game = Game();
        val player = Player("샤이", "shy")
        val another = Player("검은조직", "anonymous@8")

        game.join(player)
        game.join(another)

        game.players.size shouldBe 2
        game.players shouldContain player
        game.players shouldContain another
    }

    "동일한 플레이어가 게임에 참가시 오류가 발생한다." {
        val game = Game();
        val player = Player("샤이", "shy")
        val another = Player("샤이", "shy")

        val exception = shouldThrow<IllegalStateException> {
            game.join(player)
            game.join(another)
        }

        exception.message shouldBe "이미 참가한 플레이어 입니다."
    }
})

