package son.day2

import internal.study.kotlin.son.day2.Dice
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

/*
주사위는 주사위 눈(eyes)을 가진다.
단, 주사위 눈은 주사위 생성 시점엔 값을 가지지 않는다.
주사위는 주사위를 굴리는 기능(roll)이 있다.
주사위를 굴리면 1~6 사이 숫자를 부여받고, 그 값을 외부로 반환한다.
주사위는 주사위를 굴려 나온 값을 볼 수 있는 기능(view)이 있다.
단, 주사위를 굴리기 전엔 볼 수 없다.
*/

class Day2Mission : StringSpec({

    "주사위 눈은 주사위 생성 시점엔 값을 가지지 않으며 Roll 전 조회 시 IllegalStateException 에러가 발생한다." {
        val dice = Dice()

        val error: IllegalStateException = shouldThrow<IllegalStateException> {
            dice.view()
        }
        error.message shouldBe "주사위를 굴려주세요."
    }

    "주사위는 주사위를 굴리는 기능(roll)있으며 1~6 사이 숫자를 부여받는다." {
        val dice = Dice()

        val result = dice.roll()
        val eyes = dice.view()

        result shouldBeInRange 1..6
        eyes shouldBeInRange 1..6
    }
})