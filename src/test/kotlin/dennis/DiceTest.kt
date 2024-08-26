package dennis

import internal.study.kotlin.dennis.Dice
import internal.study.kotlin.dennis.DiceNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DiceTest {
    @Test
    fun `Dice는 DiceNumber를 가지고 있어야 한다`() {
        val dice = Dice(DiceNumber.from(3))
        assertEquals(3, dice.diceNumber.value)
    }
}
