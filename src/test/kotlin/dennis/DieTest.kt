package dennis

import internal.study.kotlin.dennis.Die
import internal.study.kotlin.dennis.DieNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DieTest {
    @Test
    fun `Dice는 DiceNumber를 가지고 있어야 한다`() {
        val die = Die(DieNumber.from(3))
        assertEquals(3, die.dieNumber.value)
    }
}
