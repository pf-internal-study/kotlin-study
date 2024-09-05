package shy

import internal.study.kotlin.shy.Game
import internal.study.kotlin.shy.Player
import internal.study.kotlin.shy.Round
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeOneOf
import io.kotest.matchers.shouldBe

class Day4Mission: BehaviorSpec({

    Given("게임을 참가한 사람들은") {
        val players: List<Player> = listOf(
            Player("샤이", "shy"),
            Player("포비", "pobi"),
            Player("침", "chim"),
            Player("손", "son"),
            Player("민", "min")
        )
        When("라운드마다") {
            val round = Round()
            Then("승자를 반환한다.")

            val actual = round.run(players);
            actual shouldBeOneOf players
            actual shouldBe round.winner
        }
    }
})
