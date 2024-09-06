package internal.study.kotlin.min

data class RecordMin(
    val player: PlayerMin,
    val diceResults: List<Int>,
    val attempts: Int
) {
    val score: Int = diceResults.sum()

    override fun toString(): String {
        return "Attempts $attempts - ${player.name}: $score (${diceResults.joinToString(", ")})"
    }
}
