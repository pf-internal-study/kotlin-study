import internal.study.kotlin.min.DiceMin
import internal.study.kotlin.min.GameMin
import internal.study.kotlin.min.PlayerMin
import internal.study.kotlin.min.RoundMin
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class Day4Mission : StringSpec({

    "플레이어는 게임 참가시 주사위 5개를 지급받는다" {
        val min = PlayerMin("min")
        val game = GameMin()
        game.join(min)

        val diceResults = min.getDiceResults()
        diceResults shouldNotBe null
        diceResults.size shouldBe 5
    }

    "플레이어는 주사위를 할당받은 이후 변경할 수 없다." {
        val exception = shouldThrow<IllegalStateException> {
            val min = PlayerMin("min")
            val game = GameMin()
            game.join(min)
            min.setDice(List(5) {DiceMin()})
        }
        exception.message shouldBe "주사위는 할당받은 이후 변경할 수 없습니다."
    }

    "플레이어의 주사위 결과가 기록된다" {
        val player1 = PlayerMin("min")
        val player2 = PlayerMin("shy")
        val game = GameMin()
        game.join(player1)
        game.join(player2)

        val round = RoundMin()
        round.run(game.players)

        val records = round.records
        records.size shouldBe 2
        records.containsKey(player1) shouldBe true
        records.containsKey(player2) shouldBe true
    }

    "라운드 승자가 선정된다" {
        val player1 = PlayerMin("min")
        val player2 = PlayerMin("chim")
        val game = GameMin()
        game.join(player1)
        game.join(player2)

        val round = RoundMin()
        round.run(game.players)

        val winner = round.getRoundWinner()
        (winner == player1 || winner == player2) shouldBe true
    }

    "5명의 플레이어가 참가하여 게임을 실행했을 때 최종 승자를 반환한다" {
        val players = listOf(
            PlayerMin("민"),
            PlayerMin("침"),
            PlayerMin("손"),
            PlayerMin("샤이"),
            PlayerMin("포비")
        )
        val game = GameMin()
        players.forEach { game.join(it) }

        game.run()

        val winner = game.getFinalWinner()
        players.contains(winner) shouldBe true
    }
})
