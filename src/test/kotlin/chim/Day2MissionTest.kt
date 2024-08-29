package chim

import internal.study.kotlin.chim.Dice
import internal.study.kotlin.chim.DiceEyes
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class Day2MissionTest : StringSpec({

    "주사위는 별도 파라미터 없이 생성 가능하다." {
        val dice = Dice()

        dice shouldNotBe null
    }

    "주사위는 주사위를 굴려 1~6 사이 숫자를 부여받고 외부로 그 값을 반환한다." {
        val dice = Dice()
        val actual = dice.roll()

        actual shouldBeInRange (1..6)
    }

    "주사위 눈을 생성하면 1~6 사이 숫자를 부여받는다" {
        val eyes = DiceEyes()

        eyes.point shouldBeInRange (1..6)
    }

    "주사위를 굴린 후 주사위 눈을 보면 이전에 굴려서 나온 값이 반환된다." {
        val dice = Dice()
        val rolled = dice.roll()
        val actual = dice.view()

        actual shouldBe rolled
    }

    "주사위를 굴리기 전에 주사위 눈을 보려고 시도하면 예외가 발생한다" {
        val dice = Dice()
        val exception = shouldThrow<UninitializedPropertyAccessException> {
            dice.view()
        }

        exception.message shouldBe "lateinit property eyes has not been initialized"
    }
})
