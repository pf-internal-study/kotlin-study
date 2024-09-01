package pobi

import internal.study.kotlin.pobi.Game
import internal.study.kotlin.pobi.Player
import internal.study.kotlin.pobi.Round
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull

class RoundTest : StringSpec({
    "라운드를 생성하면 기록지와 승자는 비어있다." {
        val actual = Round(1)
        actual.records shouldHaveSize 0
        actual.roundWinner.shouldBeNull()
    }

    "게임을 시작할 수 있다." {
        val round = Round(1)
        val game = Game()
        val player1 = Player("유진탁", "포비")
        val player2 = Player("이재근", "샤이")

        game.joinPlayer(player1)
        game.joinPlayer(player2)

        round.run(game.players)
        round.records shouldHaveSize 2
        round.roundWinner.shouldNotBeNull()
    }
})
