package pobi

import internal.study.kotlin.pobi.Dice
import internal.study.kotlin.pobi.Round
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldHave

class RoundTest : StringSpec({
    "라운드를 생성하면 기록지와 승자는 비어있다." {
        val actual = Round(1)
        actual.getRecords() shouldHaveSize  0
        actual.roundWinner shouldBe null
    }
})
