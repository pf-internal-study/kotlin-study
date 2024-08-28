package internal.study.kotlin.pobi

class Game {
    private var _rounds: MutableList<Round> = mutableListOf()
    private var _players: MutableList<Player> = mutableListOf()
    private var finalWinner: Player? = null

    fun joinPlayer(invitePlayer: Player) {
        require(_rounds.isEmpty()) { "라운드 진행중에는 게임을 참여할수 없습니다." }
        check(!_players.contains(invitePlayer)) { "동일한 플레이어는 참가할수 없습니다." }

        _players.add(invitePlayer)
    }

    fun setFinalWinner() {
        // todo
    }

    fun getPlayers(): List<Player> {
        return _players.toList();
    }

    fun nextRound(round: Round) {
        if (_rounds.size < 10) {
            this._rounds.add(round)
        }
    }

}
