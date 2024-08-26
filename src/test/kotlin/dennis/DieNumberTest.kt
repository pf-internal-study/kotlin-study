package dennis

import internal.study.kotlin.dennis.DieNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class DieNumberTest {
    @Test
    fun `DiceNumber는 1에서 6 사이의 값으로 생성되어야 한다`() {
        val dieNumber = DieNumber.from(3)
        assertEquals(3, dieNumber.value)
    }

    @Test
    fun `DiceNumber는 1보다 작은 값으로 생성될 수 없다`() {
        assertThrows<IllegalArgumentException> {
            DieNumber.from(0)
        }
    }

    @Test
    fun `DiceNumber는 6보다 큰 값으로 생성될 수 없다`() {
        assertThrows<IllegalArgumentException> {
            DieNumber.from(7)
        }
    }
}
