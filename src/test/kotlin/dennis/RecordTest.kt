package dennis

import internal.study.kotlin.dennis.Die
import internal.study.kotlin.dennis.DieNumber
import internal.study.kotlin.dennis.Player
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import internal.study.kotlin.dennis.Record as Record

class RecordTest {
    @Test
    fun `주사위추가_리스트에_주사위를_추가한다`() {
        val player = Player("John")
        val record = Record(player)
        val die = Die(DieNumber.from(6))

        record.addDie(die)

        assertEquals(1, record.dice.size)
        assertEquals(die, record.dice[0])
    }

    @Test
    fun `주사위추가_5개_이상_추가시_예외를_발생시킨다`() {
        val player = Player("John")
        val record = Record(player)

        repeat(5) {
            record.addDie(Die(DieNumber.from(6)))
        }

        assertThrows<IllegalArgumentException> {
            record.addDie(Die(DieNumber.from(6)))
        }
    }

    @Test
    fun `플레이어이름_올바른_플레이어_이름을_반환한다`() {
        val player = Player("John")
        val record = Record(player)

        assertEquals("John", record.playerName)
    }

    @Test
    fun `주사위_올바른_주사위_목록을_반환한다`() {
        val player = Player("John")
        val record = Record(player)
        val die1 = Die(DieNumber.from(6))
        val die2 = Die(DieNumber.from(4))

        record.addDie(die1)
        record.addDie(die2)

        assertEquals(listOf(die1, die2), record.dice)
    }
}
