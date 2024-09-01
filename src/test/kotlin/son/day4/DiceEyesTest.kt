package son.day4

import internal.study.kotlin.son.day4.DiceEyes
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class DiceEyesTest : StringSpec({

    "정상적인_주사위_눈_생성" {
        val dice = DiceEyes.of(3)
        dice.eyes shouldBe 3
    }

    "잘못된_주사위_눈_생성_실패" {
        shouldThrow<IllegalArgumentException> {
            DiceEyes.of(7)
        }
        shouldThrow<IllegalArgumentException> {
            DiceEyes.of(0)
        }
    }
})