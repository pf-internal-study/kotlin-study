package internal.study.kotlin.chim


fun Map<Player, List<Int>>.winnerPlayers(): List<Player> {
    val maxPoint = entries.maxOf { it.value.sum() }
    return entries.filter { it.value.sum() == maxPoint }
        .map { it.key }
}
