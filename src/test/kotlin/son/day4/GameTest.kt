package son.day4

import internal.study.kotlin.son.day4.DiceEyes
import internal.study.kotlin.son.day4.Game
import internal.study.kotlin.son.day4.Player
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeOneOf
import io.kotest.matchers.shouldBe


class GameTest : StringSpec({

    "게임은 단일 라운드에서 우승자를 결정해야 한다" {
        val player1 = Player("Player1", listOf(
            DiceEyes.of(6), DiceEyes.of(6), DiceEyes.of(6),
            DiceEyes.of(6), DiceEyes.of(6)
        ))
        val player2 = Player("Player2", listOf(
            DiceEyes.of(1), DiceEyes.of(1), DiceEyes.of(1),
            DiceEyes.of(1), DiceEyes.of(1)
        ))

        val game = Game(listOf(player1, player2), numberOfRounds = 1)
        val winner = game.play()
        winner.name shouldBe "Player1"
    }

    "게임은 여러 라운드에서 우승자를 결정해야 한다" {
        val player1 = Player("Player1", listOf(
            DiceEyes.of(6), DiceEyes.of(5), DiceEyes.of(4),
            DiceEyes.of(3), DiceEyes.of(2)
        ))
        val player2 = Player("Player2", listOf(
            DiceEyes.of(1), DiceEyes.of(1), DiceEyes.of(1),
            DiceEyes.of(1), DiceEyes.of(1)
        ))

        val game = Game(listOf(player1, player2), numberOfRounds = 3)
        val winner = game.play()
        winner.name shouldBe "Player1"
    }

    "게임은 최종 라운드 후 동점자가 있으면 재경기를 수행해야 한다" {
        val player1 = Player("Player1", listOf(
            DiceEyes.of(6), DiceEyes.of(6), DiceEyes.of(6),
            DiceEyes.of(6), DiceEyes.of(6)
        ))
        val player2 = Player("Player2", listOf(
            DiceEyes.of(6), DiceEyes.of(6), DiceEyes.of(6),
            DiceEyes.of(6), DiceEyes.of(6)
        ))

        val game = Game(listOf(player1, player2), numberOfRounds = 3)
        val winner = game.play()
        winner.name shouldBeOneOf listOf("Player1", "Player2")
    }

    "게임은 여러 라운드 후 재경기에서 우승자를 결정해야 한다" {
        val player1 = Player("Player1", listOf(
            DiceEyes.of(6), DiceEyes.of(6), DiceEyes.of(6),
            DiceEyes.of(6), DiceEyes.of(6)
        ))
        val player2 = Player("Player2", listOf(
            DiceEyes.of(6), DiceEyes.of(6), DiceEyes.of(6),
            DiceEyes.of(6), DiceEyes.of(6)
        ))
        val player3 = Player("Player3", listOf(
            DiceEyes.of(1), DiceEyes.of(1), DiceEyes.of(1),
            DiceEyes.of(1), DiceEyes.of(1)
        ))

        val game = Game(listOf(player1, player2, player3), numberOfRounds = 5)
        val winner = game.play()

        // 랜덤이라 둘 중 하나가 나와야 함
        winner.name shouldBeOneOf listOf("Player1", "Player2")
    }
})