package son.day4

import internal.study.kotlin.son.day4.Game
import internal.study.kotlin.son.day4.Player
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeOneOf
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe


class GameTest : StringSpec({

    /*
    "게임은 단일 라운드에서 우승자를 결정해야 한다" {
        val player1 = Player("Player1", listOf(
            DiceEyes.of(6), DiceEyes.of(6), DiceEyes.of(6),
            DiceEyes.of(6), DiceEyes.of(6)
        ))
        val player2 = Player("Player2", listOf(
            DiceEyes.of(1), DiceEyes.of(1), DiceEyes.of(1),
            DiceEyes.of(1), DiceEyes.of(1)
        ))

        val game = Game(listOf(player1, player2), numberOfRounds = 2)
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
    */


    "고정된 주사위 값으로 승자를 결정할 수 있어야 한다" {
        val playerA = Player.withFixedDice("Player A", listOf(1, 1, 1, 1, 1)) // 총 5점
        val playerB = Player.withFixedDice("Player B", listOf(6, 6, 6, 6, 6)) // 총 30점
        val playerC = Player.withFixedDice("Player C", listOf(2, 2, 2, 2, 2)) // 총 10점

        val players = listOf(playerA, playerB, playerC)
        val game = Game(players, 1)

        // Player B가 가장 높은 점수로 승리해야 함
        val winner = game.play()
        winner.name shouldBe "Player B"
    }

    "동점자가 발생하면 재경기에서 승자가 결정되어야 한다" {
        val playerA = Player.withFixedDice("Player A", listOf(3, 3, 3, 3, 3)) // 총 15점
        val playerB = Player.withFixedDice("Player B", listOf(3, 3, 3, 3, 3)) // 총 15점
        val playerC = Player.withFixedDice("Player C", listOf(2, 2, 2, 2, 2)) // 총 10점

        val players = listOf(playerA, playerB, playerC)
        val game = Game(players, 1)

        // 동점자가 발생할 것이며, 재경기에서 승자가 나와야 함
        val winner = game.play()

        // Player A 또는 Player B 중 한 명이 승리해야 함
        winner.name shouldBeOneOf listOf("Player A", "Player B")
    }

    "여러 라운드 후 최종 승자가 나와야 한다" {
        val playerA = Player.withFixedDice("Player A", listOf(2, 2, 2, 2, 2)) // 총 10점
        val playerB = Player.withFixedDice("Player B", listOf(6, 6, 6, 6, 6)) // 총 30점
        val playerC = Player.withFixedDice("Player C", listOf(3, 3, 3, 3, 3)) // 총 15점

        val players = listOf(playerA, playerB, playerC)
        val game = Game(players, 3)

        // Player B가 최종 승자가 되어야 함
        val winner = game.play()
        winner.name shouldBe "Player B"
    }

    "동점자가 발생한 경우 재경기에서 고정된 점수로 승부를 가려야 한다" {
        // 첫 라운드에서 동점자가 발생
        val playerA = Player.withFixedDice("Player A", listOf(4, 4, 4, 4, 4)) // 총 20점
        val playerB = Player.withFixedDice("Player B", listOf(4, 4, 4, 4, 4)) // 총 20점
        val playerC = Player.withFixedDice("Player C", listOf(1, 1, 1, 1, 1)) // 총 5점

        val players = listOf(playerA, playerB, playerC)
        val game = Game(players, 1)

        // 동점자가 발생할 것이며, 재경기에서 승자가 나와야 함
        val winner = game.play()

        // Player A 또는 Player B 중 한 명이 승리해야 함
        winner.name shouldBeOneOf listOf("Player A", "Player B")
    }
})