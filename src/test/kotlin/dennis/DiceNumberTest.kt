package dennis

import internal.study.kotlin.dennis.DiceNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class DiceNumberTest {

    @Test
    fun `DiceNumber는 1에서 6 사이의 값으로 생성되어야 한다`() {
        val diceNumber = DiceNumber.from(3)
        assertEquals(3, diceNumber.value)
    }

    @Test
    fun `DiceNumber는 1보다 작은 값으로 생성될 수 없다`() {
        assertThrows<IllegalArgumentException> {
            DiceNumber.from(0)
        }
    }

    @Test
    fun `DiceNumber는 6보다 큰 값으로 생성될 수 없다`() {
        assertThrows<IllegalArgumentException> {
            DiceNumber.from(7)
        }
    }
}
