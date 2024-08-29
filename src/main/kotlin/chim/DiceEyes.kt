package internal.study.kotlin.chim

class DiceEyes {
    val point: Int = range.random()

    companion object {
        private val range: List<Int> = listOf(1, 2, 3, 4, 5, 6)
    }
}
