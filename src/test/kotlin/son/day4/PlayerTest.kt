package son.day4

import internal.study.kotlin.son.day4.DiceEyes
import internal.study.kotlin.son.day4.Player
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PlayerTest : StringSpec({

    "플래아어는 5개 주사위를 굴린다." {
        val player = Player("Son")
        player.dice.size shouldBe 5
    }

    "플레이어 점수는 주사위 눈의 합이다." {
        val player = Player("Son", listOf(
            DiceEyes.of(1),
            DiceEyes.of(2),
            DiceEyes.of(3),
            DiceEyes.of(4),
            DiceEyes.of(5)
        ))
        player.score shouldBe 15
    }

})