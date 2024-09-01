package son.day4

import internal.study.kotlin.son.day4.Player
import internal.study.kotlin.son.day4.Records
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly

class RecordsTest : StringSpec({

    "플레이어 점수를 기록해야 한다." {
        val records = Records()
        val player = Player("Son")
        records.record(player, 10)

        records.getTopPlayers() shouldContainExactly listOf(player)
    }

    "최고 점수를 가진 플레이어를 가릴 수 있어야 한다" {
        val records = Records()
        val player1 = Player("Player1")
        val player2 = Player("Player2")
        val player3 = Player("Player3")

        records.record(player1, 10)
        records.record(player2, 20)
        records.record(player3, 20)

        records.getTopPlayers() shouldContainExactly listOf(player2, player3)
    }
})