package son.day4

import internal.study.kotlin.son.day4.DiceEyes
import internal.study.kotlin.son.day4.Player
import internal.study.kotlin.son.day4.Round
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeOneOf
import io.kotest.matchers.shouldBe


class RoundTest : StringSpec({

    "라운드는 우승자를 결정해야 한다." {
        val playerA = Player("PlayerA", listOf(
            DiceEyes.of(3), DiceEyes.of(3), DiceEyes.of(3),
            DiceEyes.of(3), DiceEyes.of(3)
        )) // 15 points
        val playerB = Player("PlayerB", listOf(
            DiceEyes.of(4), DiceEyes.of(4), DiceEyes.of(4),
            DiceEyes.of(5), DiceEyes.of(5)
        )) // 22 points
        val playerC = Player("PlayerC", listOf(
            DiceEyes.of(1), DiceEyes.of(1), DiceEyes.of(1),
            DiceEyes.of(1), DiceEyes.of(1)
        )) // 5 points

        val round = Round(listOf(playerA, playerB, playerC))
        val winner = round.play()

        winner.name shouldBe "PlayerB"
    }

    "라운드는 동점자들간의 재경기를 수행해야 한다." {
        val playerB = Player("PlayerB", listOf(
            DiceEyes.of(4), DiceEyes.of(4), DiceEyes.of(4),
            DiceEyes.of(5), DiceEyes.of(5)
        )) // 22 points
        val playerC = Player("PlayerC", listOf(
            DiceEyes.of(4), DiceEyes.of(4), DiceEyes.of(4),
            DiceEyes.of(5), DiceEyes.of(5)
        )) // 22 points

        val round = Round(listOf(playerB, playerC))
        val winner = round.play()

        // Both B and C tied in the initial round, so the rematch decides the winner.
        winner.name shouldBeOneOf listOf("PlayerB", "PlayerC")
    }

    "재경기에서 최종 우승자를 결정해야 한다" {
        val playerA = Player("PlayerA", listOf(
            DiceEyes.of(3), DiceEyes.of(3), DiceEyes.of(3),
            DiceEyes.of(3), DiceEyes.of(3)
        )) // 15 points
        val playerB = Player("PlayerB", listOf(
            DiceEyes.of(4), DiceEyes.of(4), DiceEyes.of(4),
            DiceEyes.of(5), DiceEyes.of(5)
        )) // 22 points
        val playerC = Player("PlayerC", listOf(
            DiceEyes.of(4), DiceEyes.of(4), DiceEyes.of(4),
            DiceEyes.of(5), DiceEyes.of(5)
        )) // 22 points
        val playerD = Player("PlayerD", listOf(
            DiceEyes.of(2), DiceEyes.of(2), DiceEyes.of(2),
            DiceEyes.of(1), DiceEyes.of(1)
        )) // 8 points
        val playerE = Player("PlayerE", listOf(
            DiceEyes.of(3), DiceEyes.of(3), DiceEyes.of(3),
            DiceEyes.of(3), DiceEyes.of(3)
        )) // 15 points

        val round = Round(listOf(playerA, playerB, playerC, playerD, playerE))
        val winner = round.play()

        // The final winner should be determined correctly after the rematch
        winner.name shouldBe "PlayerB"
    }
})