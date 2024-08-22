package pobi

import internal.study.kotlin.pobi.Dice
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DiceTest : StringSpec({
    "주사위를 생성할때에는 값을 가지지 않는다" {
        val actual = Dice();
        println(actual.eyes)
        actual.eyes shouldBe null
    }

    "주사위를 굴리면 1~6 숫자를 반환한다" {
        val actual = Dice();
        val eyes = actual.roll();
        println(actual.eyes)
        actual.eyes shouldBe eyes
    }

    "주사위를 굴리기 전에는 view 함수로 값을 확인할수 없다" {
        val actual = Dice();
        val eyes = actual.view();
        println(actual.eyes)
        eyes shouldBe null
    }

    "주사위를 굴리면 view 함수로 값을 확인할수 있다." {
        val actual = Dice();
        actual.roll();
        val eyes = actual.view();
        println(eyes)
        eyes shouldBe actual.eyes
    }
})
