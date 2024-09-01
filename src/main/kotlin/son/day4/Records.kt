package internal.study.kotlin.son.day4

//라운드 > 기록지 > 플레이어
/*
기록지(records)에는 플레이어마다 해당 라운드에 던진 5개 주사위의 눈금 결과가 기록된다.
라운드가 가지는 기록지는 1개이며, 기록지 1개에 여러 플레이어의 기록이 담겨있다.
라운드가 생성될 때 기록지는 비어있다. (empty)
*/

class Records {
    private val _records = mutableListOf<Pair<Player, Int>>()

    fun record(player: Player, score: Int) {
        _records.add(player to score)
    }

    fun getTopPlayers(): List<Player> {
        val maxScore = _records.maxOfOrNull { it.second } ?: 0
        return _records.filter { it.second == maxScore }.map { it.first }
    }

    fun clear() {
        _records.clear()
    }
}