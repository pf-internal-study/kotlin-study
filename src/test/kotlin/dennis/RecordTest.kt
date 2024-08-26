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
    fun `addDie adds a die to the list`() {
        val player = Player("John")
        val record = Record(player)
        val die = Die(DieNumber.from(6))

        record.addDie(die)

        assertEquals(1, record.dice.size)
        assertEquals(die, record.dice[0])
    }

    @Test
    fun `addDie throws exception when more than 5 dice are added`() {
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
    fun `playerName returns the correct player name`() {
        val player = Player("John")
        val record = Record(player)

        assertEquals("John", record.playerName)
    }

    @Test
    fun `dice returns the correct list of dice`() {
        val player = Player("John")
        val record = Record(player)
        val die1 = Die(DieNumber.from(6))
        val die2 = Die(DieNumber.from(4))

        record.addDie(die1)
        record.addDie(die2)

        assertEquals(listOf(die1, die2), record.dice)
    }
}
