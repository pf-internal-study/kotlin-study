package min

import internal.study.kotlin.min.DiceMin
import internal.study.kotlin.min.GLOBAL_NOT_ROLLED_MESSAGE
import internal.study.kotlin.min.PlayerMin
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class DiceMinTest : StringSpec({

    "주사위는 생성시점에 눈이 초기화되지 않는다." {
        val dice = DiceMin()
        //dice.eyes = 1
        dice.getEyes() shouldBe null
    }


    "주사위는 굴리기전에 볼수 수 없다." {
        val exception = shouldThrow<IllegalStateException> {
            val dice = DiceMin()
            dice.view()
        }
        exception.message shouldBe DiceMin.MEMBER_NOT_ROLLED_MESSAGE
    }

    "주사위는 굴리기전에 볼수 수 없다.2" {
        val exception = shouldThrow<IllegalStateException> {
            val dice = DiceMin()
            dice.view2()
        }
        exception.message shouldBe GLOBAL_NOT_ROLLED_MESSAGE
    }

    "주사위를 굴리면 주사위 눈을 볼 수 있다." {
        val exception = shouldNotThrow<Exception> {
            val dice = DiceMin()
            dice.roll()
            dice.view()
        }
        exception shouldBe Unit
    }

    "주사위를 굴리면 1 과 6 사이의 눈을 반환한다." {
        val dice = DiceMin()
        val eyes = dice.roll()
        val view = dice.view()

        val eyes2 = dice.roll()
        val view2 = dice.view()

        eyes shouldBeInRange (1..6)
        view shouldBeInRange (1..6)
        eyes shouldBeEqual view

        eyes2 shouldBeInRange (1..6)
        view2 shouldBeInRange (1..6)
        eyes2 shouldBeEqual view2
    }
})
