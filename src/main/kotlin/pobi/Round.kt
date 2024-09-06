package internal.study.kotlin.pobi

class Round(val id: Int) {
    private var _records: MutableList<Record> = mutableListOf()
    private var _roundWinner: Player? = null


    val records: List<Record>
        get() = _records.toList()

    val roundWinner: Player?
        get() = _roundWinner

    fun run(players: List<Player>): Player? {
        require(players.isNotEmpty()) { "플레이어가 없으면 게임을 진행할 수 없습니다." }

        /* 라운드 진행 */
        for (player in players) {
            player.rollDices()
            val totalEyes = player.getTotalEyes()
            println(player.name + ", " + player.nickname + ", " + totalEyes)
            _records.add(Record(totalEyes, player));
        }

        /* 승자 확인 */
        val winnerPlayers = getWinners(_records)

        _roundWinner = when {
            winnerPlayers.size == 1 -> winnerPlayers.first().getPlayer()
            else -> run(winnerPlayers.map { it.getPlayer() })
        }
        println(_roundWinner);
        return roundWinner!!
    }

    private fun getWinners(records: MutableList<Record>): MutableList<Record> {
        val topPoint: Int = getTopPoint();
        val winnerRecord = records.filter { it.getTotalPoint() == topPoint }.toMutableList();
        return winnerRecord
    }

    fun getTopPoint(): Int {
        return _records.maxByOrNull { it.getTotalPoint() }?.getTotalPoint()!!
    }

}
