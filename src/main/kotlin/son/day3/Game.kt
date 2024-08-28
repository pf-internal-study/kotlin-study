package internal.study.kotlin.son.day3
/*
게임은 진행될 라운드(rounds)와 참여할 플레이어(players) 그리고 최종 우승자(winner)를 가진다.
게임은 10라운드로 이루어져 있다.
게임이 시작된 후 라운드 목록은 변경할 수 없다.
게임은 플레이어의 참가 지원을 받는 기능(join)이 있다.
지원한 플레이어는 참여 플레이어 (players)에 등록된다.
동일한 플레이어는 지원할 수 없다.
최종 우승자(winner)는 게임이 종료될 때, 가장 많은 라운드를 승리한 플레이어로 결정된다.
최종 우승자가 정해지기 전까지 우승자는 없다.
*/
class Game(round: Int = 10) {
    private var _players = mutableListOf<Player>()
    private val _rounds = round
    private var _winner: Player? = null
    private var _isStart: Boolean = false

    init {
        require(round > 1) { MIN_ROUND }
    }

    fun getRounds(): Int {
        return _rounds
    }

    fun join(player: Player) {
        require(!_players.contains(player)) { ALREADY_JOINED_PLAYER }
        _players.add(player)
    }

    fun join(players: List<Player>) {
        players.forEach { player ->
            require(!this._players.contains(player)) { ALREADY_JOINED_PLAYER }
        }
        this._players.addAll(players)
    }

    fun start() {
        require(_players.isNotEmpty()) { NOT_FOUND_PLAYER }
        require(!_isStart) { ALREADY_STARTED_GAME }

        _isStart = true
    }

    fun finish() {
        require(_isStart) { NOT_STARTED_GAME }

        val winner = _players.maxByOrNull { it.winCount() }
        this._winner = winner
    }

    companion object {
        private const val NOT_FOUND_PLAYER = "참가한 플레이어가 없습니다."
        private const val ALREADY_STARTED_GAME = "이미 시작된 게임입니다."
        private const val ALREADY_JOINED_PLAYER = "이미 참가한 플레이어입니다."
        private const val MIN_ROUND = "라운드는 최소 1개 이상이여야합니다. "
        private const val NOT_STARTED_GAME = "게임이 시작되지 않았습니다."
    }
}