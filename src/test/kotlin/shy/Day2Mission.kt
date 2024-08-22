package shy

import internal.study.kotlin.shy.Dice
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class Day2Mission: StringSpec ({
    "주사위를 생성시 값을 가지지 않는다" {
        var dice = Dice()

        dice.eyes shouldBe null
    }

    "주사위를 굴리면 값을 반환한다." {
        var dice = Dice()
        var eyes: Int = dice.roll()

        eyes shouldBeInRange (1..6)
    }

    "주사위를 굴리지 않으면 값을 볼 수 없다." {
        var dice = Dice()

        var exception = shouldThrow<Exception> {
            dice.view()
        }

        exception.message shouldBe "주사위를 먼저 굴려주세요."
    }

    "주사위가 굴렀다면 현재 값을 보여준다." {
        var dice = Dice()
        dice.roll()

        var exception = shouldNotThrow<Exception> {
            dice.view()
        }

        exception  shouldBe Unit
    }
})

