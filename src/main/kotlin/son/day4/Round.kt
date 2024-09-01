package internal.study.kotlin.son.day4
class Round(private val players: List<Player>) {
    private val records = Records()

    init {
        players.forEach { player ->
            records.record(player, player.score)
        }
    }

    fun play(): Player {
        val topPlayers = records.getTopPlayers()
        return topPlayers.first()
    }
}